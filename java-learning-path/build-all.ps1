# Java Learning Path - Quick Build Script
# This PowerShell script builds and tests all modules

Write-Host "=== Java Learning Path - Building All Modules ===" -ForegroundColor Cyan
Write-Host ""

# Use current directory as base path
$basePath = $PSScriptRoot
$successCount = 0
$failCount = 0
$results = @()

# 1. Java Basics topics (19)
$javaBasicsTopics = @(
    "basic-syntax",
    "setup-and-tooling",
    "variables-and-data-types",
    "operators-and-expressions",
    "control-flow",
    "methods-and-parameters",
    "arrays",
    "strings",
    "packages-and-imports",
    "exceptions",
    "collections-framework",
    "generics",
    "lambdas-and-streams",
    "dates-and-time",
    "file-io-and-nio",
    "concurrency-basics",
    "debugging-and-logging",
    "unit-testing-junit",
    "build-tools-maven"
)

# 2. OOP with Java topics (17)
$oopTopics = @(
    "classes-and-objects",
    "encapsulation",
    "inheritance",
    "polymorphism",
    "abstraction",
    "interfaces",
    "abstract-classes",
    "method-overloading",
    "method-overriding",
    "static-members",
    "inner-classes",
    "composition-vs-inheritance",
    "enums",
    "object-equality-hashcode-tostring",
    "immutability",
    "solid-principles",
    "design-patterns-intro"
)

# 3. Large Projects (2)
$projectTopics = @(
    "library-management",
    "ecommerce-cart"
)

function Build-Topic {
    param([string]$category, [string]$topic)
    
    $topicPath = Join-Path $basePath "$category\$topic"
    
    if (Test-Path $topicPath) {
        Write-Host "Building $category/$topic..." -ForegroundColor Yellow
        Push-Location $topicPath
        
        try {
            # Check if mvn is available
            if (Get-Command mvn -ErrorAction SilentlyContinue) {
                $output = mvn clean test 2>&1
                if ($LASTEXITCODE -eq 0) {
                    Write-Host "  ✓ Success" -ForegroundColor Green
                    $script:successCount++
                    return @{Topic="$category/$topic"; Status="Success"}
                } else {
                    Write-Host "  ✗ Failed" -ForegroundColor Red
                    $script:failCount++
                    return @{Topic="$category/$topic"; Status="Failed"}
                }
            } else {
                Write-Host "  ! Warning: 'mvn' not found. Skipping build." -ForegroundColor Gray
                return @{Topic="$category/$topic"; Status="MvnNotFound"}
            }
        }
        catch {
            Write-Host "  ✗ Error: $_" -ForegroundColor Red
            $script:failCount++
            return @{Topic="$category/$topic"; Status="Error"}
        }
        finally {
            Pop-Location
        }
    } else {
        Write-Host "  - Skipping (not found)" -ForegroundColor Gray
        return @{Topic="$category/$topic"; Status="NotFound"}
    }
}

# Build Java Basics
Write-Host "--- Building Java Basics Topics ---`n" -ForegroundColor Cyan
foreach ($topic in $javaBasicsTopics) { $results += Build-Topic "01-java-basics" $topic }

# Build OOP
Write-Host "`n--- Building OOP Topics ---`n" -ForegroundColor Cyan
foreach ($topic in $oopTopics) { $results += Build-Topic "02-oop-with-java" $topic }

# Build Projects
Write-Host "`n--- Building Large Projects ---`n" -ForegroundColor Cyan
foreach ($topic in $projectTopics) { $results += Build-Topic "03-large-projects" $topic }

# Summary
Write-Host "`n=== Build Summary ===" -ForegroundColor Cyan
Write-Host "Successful: $successCount" -ForegroundColor Green
Write-Host "Failed: $failCount" -ForegroundColor Red
Write-Host ""

# Detailed results
Write-Host "Detailed Results:" -ForegroundColor Cyan
$results | Format-Table -Auto

if ($failCount -eq 0 -and $successCount -gt 0) {
    Write-Host "`n✓ All builds successful!" -ForegroundColor Green
} elseif ($successCount -eq 0) {
    Write-Host "`n! No builds performed (Maven likely missing)." -ForegroundColor Yellow
} else {
    Write-Host "`n⚠ Some builds failed. Check errors above." -ForegroundColor Yellow
}

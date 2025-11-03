# Java Learning Path - Quick Build Script
# This PowerShell script builds and tests all modules

Write-Host "=== Java Learning Path - Building All Modules ===" -ForegroundColor Cyan
Write-Host ""

$basePath = "c:\Users\ahbab\Downloads\oop\java-learning-path"
$successCount = 0
$failCount = 0
$results = @()

# Java Basics topics
$javaBasicsTopics = @(
    "setup-and-tooling",
    "variables-and-data-types",
    "operators-and-expressions",
    "control-flow",
    "methods-and-parameters",
    "arrays",
    "strings"
    # Add more as they're created
)

function Build-Topic {
    param([string]$category, [string]$topic)
    
    $topicPath = Join-Path $basePath "$category\$topic"
    
    if (Test-Path $topicPath) {
        Write-Host "Building $category/$topic..." -ForegroundColor Yellow
        Push-Location $topicPath
        
        try {
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
Write-Host "`n--- Building Java Basics Topics ---`n" -ForegroundColor Cyan
foreach ($topic in $javaBasicsTopics) {
    $result = Build-Topic "01-java-basics" $topic
    $results += $result
}

# Summary
Write-Host "`n=== Build Summary ===" -ForegroundColor Cyan
Write-Host "Successful: $successCount" -ForegroundColor Green
Write-Host "Failed: $failCount" -ForegroundColor Red
Write-Host ""

# Detailed results
Write-Host "Detailed Results:" -ForegroundColor Cyan
$results | Format-Table -Auto

if ($failCount -eq 0) {
    Write-Host "`n✓ All builds successful!" -ForegroundColor Green
} else {
    Write-Host "`n⚠ Some builds failed. Check errors above." -ForegroundColor Yellow
}

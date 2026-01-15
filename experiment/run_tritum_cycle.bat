@echo off
rem Automatic execution script for COMSOL model with robust error handling
rem Usage: run_tritum_cycle.bat <java_file>

if "%~1"=="" (
    echo.
    echo [ERROR] No input file specified.
    echo Usage: %~nx0 ^<java_filename^>
    echo.
    pause
    exit /b 1
)

set "JAVA_FILE=%~1"
set "CLASS_FILE=%~n1.class"

echo ==========================================
echo Processing: %JAVA_FILE%
echo ==========================================
echo Cleaning previous build artifacts...
echo ==========================================
if exist "%CLASS_FILE%" del "%CLASS_FILE%"
if exist full_cycle_plot.png del full_cycle_plot.png
if exist sds_inventory_plot.png del sds_inventory_plot.png

echo.
echo ==========================================
echo Starting COMSOL Compilation
echo ==========================================
echo Command: comsolcompile "%JAVA_FILE%"

call comsolcompile "%JAVA_FILE%"

rem Check for compilation success by verifying class file existence
if not exist "%CLASS_FILE%" (
    echo.
    echo [ERROR] Compilation failed: '%CLASS_FILE%' was not generated.
    echo Please check the log file mentioned above for details.
    pause
    exit /b 1
)

echo.
echo ==========================================
echo Starting COMSOL Batch Execution
echo ==========================================
echo Command: comsolbatch -inputfile "%CLASS_FILE%"

call comsolbatch -inputfile "%CLASS_FILE%"
if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Execution failed with error level %errorlevel%.
    pause
    exit /b %errorlevel%
)

echo.
echo ==========================================
echo All tasks completed successfully for %JAVA_FILE%.
echo ==========================================
pause

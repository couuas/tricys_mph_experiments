@echo off
rem Automatic execution script for COMSOL model with robust error handling

echo ==========================================
echo Cleaning previous build artifacts...
echo ==========================================
if exist tritum_cycle.class del tritum_cycle.class
if exist full_cycle_plot.png del full_cycle_plot.png
if exist sds_inventory_plot.png del sds_inventory_plot.png

echo.
echo ==========================================
echo Starting COMSOL Compilation
echo ==========================================
echo Command: comsolcompile tritum_cycle.java

call comsolcompile tritum_cycle.java

rem Check for compilation success by verifying class file existence
if not exist tritum_cycle.class (
    echo.
    echo [ERROR] Compilation failed: 'tritum_cycle.class' was not generated.
    echo Please check the log file mentioned above for details.
    pause
    exit /b 1
)

echo.
echo ==========================================
echo Starting COMSOL Batch Execution
echo ==========================================
echo Command: comsolbatch -inputfile tritum_cycle.class

call comsolbatch -inputfile tritum_cycle.class
if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Execution failed with error level %errorlevel%.
    pause
    exit /b %errorlevel%
)

echo.
echo ==========================================
echo All tasks completed successfully.
echo ==========================================
pause

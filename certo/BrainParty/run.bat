@echo off
REM Script para compilar e executar o BrainParty Simplificado no Windows

echo ==========================================
echo BrainParty - Jogo da Memoria Simplificado
echo ==========================================
echo.

REM Verificar se o Java está instalado
java -version >nul 2>&1
if errorlevel 1 (
    echo Erro: Java nao esta instalado. Por favor, instale o Java 11 ou superior.
    pause
    exit /b 1
)

echo Java encontrado!
echo.

REM Criar diretório bin se não existir
if not exist bin mkdir bin

REM Compilar
echo Compilando o projeto...
javac -d bin src\com\brainparty\*.java

if errorlevel 1 (
    echo Erro na compilacao. Verifique os erros acima.
    pause
    exit /b 1
)

echo Compilacao bem-sucedida!
echo.
echo Iniciando o jogo...
echo.

REM Executar
java -cp bin com.brainparty.GameGUI

pause


#!/bin/bash

# Script para compilar e executar o BrainParty Simplificado

echo "=========================================="
echo "BrainParty - Jogo da Memória Simplificado"
echo "=========================================="
echo ""

# Verificar se o Java está instalado
if ! command -v java &> /dev/null; then
    echo "❌ Java não está instalado. Por favor, instale o Java 11 ou superior."
    exit 1
fi

echo "✅ Java encontrado: $(java -version 2>&1 | head -1)"
echo ""

# Criar diretório bin se não existir
mkdir -p bin

# Compilar
echo "📦 Compilando o projeto..."
javac -d bin src/com/brainparty/*.java

if [ $? -eq 0 ]; then
    echo "✅ Compilação bem-sucedida!"
    echo ""
    echo "🎮 Iniciando o jogo..."
    echo ""
    
    # Executar
    java -cp bin com.brainparty.GameGUI
else
    echo "❌ Erro na compilação. Verifique os erros acima."
    exit 1
fi


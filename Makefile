# Diretórios
SRC_DIR=src
OUT_DIR=out
PACKAGE=com/alef/taskmanager

# Alvo principal
run:
	@mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) $(SRC_DIR)/$(PACKAGE)/*.java
	java -cp $(OUT_DIR) com.alef.taskmanager.Main

# Alvo opcional para limpar a compilação
clean:
	rm -rf $(OUT_DIR)

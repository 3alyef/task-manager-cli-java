# Diretórios
SRC_DIR=src
OUT_DIR=out
LIB_DIR=lib
LIBS=$(wildcard $(LIB_DIR)/*.jar)
CP=$(LIBS:$(LIB_DIR)/%=$(LIB_DIR)/%)

SOURCES=$(shell find $(SRC_DIR) -name "*.java")
CLASSPATH=$(subst $(space),:,$(CP))

# Build + Run
run: build
	java -cp "$(OUT_DIR):$(CLASSPATH)" com.alef.taskmanager.Main

# Compilação
build:
	mkdir -p $(OUT_DIR)
	javac -cp "$(CLASSPATH)" -d $(OUT_DIR) $(SOURCES)

# Limpeza
clean:
	rm -rf $(OUT_DIR)

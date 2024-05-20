CREATE DATABASE  TrabalhoPOO2;

USE TrabalhoPOO2;

CREATE TABLE produto (
    codigo INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao varchar(200) NOT NULL,
    preco_custo DECIMAL(10, 2) NOT NULL,
    preco_venda DECIMAL(10, 2) NOT NULL,
    quantidade_estoque INT NOT NULL,
    categoria VARCHAR(50)
);

CREATE TABLE cliente (
    codigo int primary key,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    data_nascimento DATE,
    email VARCHAR(100)
);

CREATE TABLE venda (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    cliente_codigo INT,
    forma_pagamento INT NOT NULL,
    valor_total DECIMAL(10, 2),
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cliente_codigo) REFERENCES cliente(codigo)
);

CREATE TABLE  venda_produto (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    venda_codigo INT,
    produto_codigo INT,
    quantidade INT,
    preco_unitario DECIMAL(10, 2),
    FOREIGN KEY (venda_codigo) REFERENCES venda(codigo),
    FOREIGN KEY (produto_codigo) REFERENCES produto(codigo)
);

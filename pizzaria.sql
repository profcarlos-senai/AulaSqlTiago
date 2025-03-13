CREATE TABLE clientes (
	id serial PRIMARY KEY,
	name varchar(100) NOT NULL,
	fone numeric(11)
);

CREATE TABLE pedidos (
	id serial PRIMARY KEY,
	datahora timestamp default now() NOT NULL,
	id_cliente int not null,
	foreign key (id_cliente) references clientes(id)
);

alter table clientes rename name to nome;

INSERT INTO clientes (nome, fone) values ('Juca', 46123456789),('Maria', 46987654321);

SELECT * from clientes;

SELECT id, fone from clientes;

INSERT into pedidos (id_cliente) values (1),(2);

SELECT * from pedidos;

ALTER table pedidos add entregar boolean not null default true;

ALTER table clientes add endereco varchar;

UPDATE clientes set endereco = 'Rua da Sua Mae 110' where id = 1;
UPDATE clientes set endereco = 'Rua do Seu Pai 109' where id = 2;

SELECT id, nome, endereco from clientes where id = 2;

CREATE table pizzaspedido (
	id serial PRIMARY KEY,
	pedido int not null references pedidos
)

CREATE table tamanho (
	tamanho char(1) primary key,
	preco numeric(7,2),
	qt_sabor smallint not null default 1
)

ALTER table pizzaspedido add tamanho char(1) not null, add constraint fk_tamanho foreign key (tamanho) references tamanho;

INSERT into tamanho (tamanho, preco, qt_sabor) values ('P', 35.00, 1),('M', 60.00, 2),('G', 80.00, 4);

SELECT * from tamanho;

INSERT into pizzaspedido (pedido, tamanho) values (1, 'G'),(1, 'M'),(2, 'P');

select * from pizzaspedido;

alter table pedidos RENAME to pedido;
alter table clientes RENAME to cliente;
alter table pedido RENAME id_cliente to cliente;

CREATE table sabores (
	id serial primary key,
	nome varchar(100) not null unique
)

insert into sabores (nome) values ('Calabresa'),('Margherita'),('4 Queijos'),('Chocolate');
select * from sabores order by nome desc;

alter table pizzaspedido rename to pizzapedido;

create table saborpizzapedido (
	id serial primary key,
	pizzapedido int references pizzapedido,
	sabor int references sabores
)
alter table sabores rename to sabor;
insert into saborpizzapedido (pizzapedido, sabor) values (4,1),(4,2),(4,3),(4,3),(5,4),(6,3);
select * from saborpizzapedido;

select c.nome nomecliente, s.nome nomesabor, count(*)
from cliente as c
	join pedido p on p.cliente = c.id
	join pizzapedido z on z.pedido = p.id
	join saborpizzapedido sz on sz.pizzapedido = z.id
	join sabor s on sz.sabor = s.id
group by nomesabor, nomecliente
order by nomecliente, nomesabor
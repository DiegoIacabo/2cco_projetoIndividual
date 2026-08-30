create table genero (
    id int auto_increment primary key,
    nome varchar(50) not null unique
);

create table local (
    id int auto_increment primary key,
    nome varchar(100) not null,
    capacidade int not null,
    ambiente_aberto tinyint not null
);

create table festival (
    id int auto_increment primary key,
    nome varchar(100) not null,
    qtd_atracoes int not null,
    dt_inicio date not null,
    dt_fim date not null,
    evento_publico tinyint not null,
    fk_local int not null,
    constraint fk_local_festival
        foreign key (fk_local)
            references local(id)
);

create table festival_genero(
    fk_festival int not null,
    fk_genero int not null,
    constraint fk_festival
        foreign key (fk_festival)
            references festival(id),
    constraint fk_genero
        foreign key (fk_genero)
            references genero(id),
    constraint pk_festival_genero
        primary key (fk_festival, fk_genero)
);

INSERT INTO genero (nome) VALUES
    ('Rock'),
    ('Pop'),
    ('Rap'),
    ('Sertanejo'),
    ('MPB'),
    ('Reggae'),
    ('Indie'),
    ('Funk'),
    ('Pagode');

INSERT INTO local (nome, capacidade, ambiente_aberto) VALUES
    ('Nubank Parque', 43713, 0),
    ('Autódromo de Interlagos', 80000, 1),
    ('Morumbis', 66795, 0),
    ('Sambódromo do Anhembi', 103200, 1),
    ('Espaço das Américas', 8000, 0),
    ('Audio', 3200, 0),
    ('Vibra São Paulo', 7000, 0),
    ('Vale do Anhangabaú', 40000, 1),
    ('Memorial da América Latina', 30000, 1),
    ('Canindé', 21004, 0),
    ('Espaço Unimed', 8000, 0),
    ('Centro Esportivo Tietê', 30000, 1),
    ('Parque Villa-Lobos', 60000, 1);
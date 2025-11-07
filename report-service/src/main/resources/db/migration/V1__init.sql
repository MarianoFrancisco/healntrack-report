create table dim_patient (
    id uuid primary key,
    cui varchar(13) unique not null,
    full_name varchar(150) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table dim_employee (
    id uuid primary key,
    cui char(13) unique not null,
    full_name varchar(200) not null,
    department varchar(50) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table dim_medicine (
    id uuid primary key,
    name varchar(120) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table dim_room (
    id uuid primary key,
    number varchar(10) unique not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table dim_area (
    id uuid primary key default gen_random_uuid(),
    name varchar(50) unique not null,
    entity_reference varchar(25) check (entity_reference in ('EMPLOYEE', 'MEDICINE', 'ROOM', 'PATIENT')) not null
);

create table fact_transaction (
    id uuid primary key,
    area_id uuid not null,
    type varchar(10) check (type in ('INCOME', 'EXPENSE')) not null,
    reference_id uuid unique not null,
    amount numeric(10,2) not null,
    occurred_at date not null,
    created_at timestamp not null,
    updated_at timestamp not null,
    foreign key(area_id) references dim_area(id)
);
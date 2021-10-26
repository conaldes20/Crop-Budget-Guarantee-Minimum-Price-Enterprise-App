create table Cbcrop (
    cropId int not null
        constraint pk_Cbcrop primary key,
    crop varchar(45) not null
)
insert into Cbcrop (cropId,crop) values (1,'MAIZE - GRAIN (WHITE)')
insert into Cbcrop (cropId,crop) values (2,'MIZE - GRAIN (YELLOW)') 
insert into Cbcrop (cropId,crop) values (3,'BEANS - BROWN') 
insert into Cbcrop (cropId,crop) values (4,'BEANS - WHITE') 
insert into Cbcrop (cropId,crop) values (5,'RICE - LOCAL') 
insert into Cbcrop (cropId,crop) values (6,'PADDY RICE') 
insert into Cbcrop (cropId,crop) values (7,'RICE - IMPORTED')
insert into Cbcrop (cropId,crop) values (8,'SURGHUM')
insert into Cbcrop (cropId,crop) values (9,'COWPEAS')
insert into Cbcrop (cropId,crop) values (10,'MILLET')
insert into Cbcrop (cropId,crop) values (11,'SOYA BEANS')
update cbcrop set crop = 'SORGHUM' where cropId = 8

create table Cblocation (
    locationId int not null
        constraint pk_Cblocation primary key,
    location varchar(75) not null
)
insert into Cblocation (locationId,location) values (1,'NORTH-CENTRAL')
insert into Cblocation (locationId,location) values (2,'NORTH-EAST') 
insert into Cblocation (locationId,location) values (3,'NORTH-WEST') 
insert into Cblocation (locationId,location) values (4,'SOUTH-EAST') 
insert into Cblocation (locationId,location) values (5,'SOUTH-WEST') 
insert into Cblocation (locationId,location) values (6,'SOUTH-SOUTH') 
insert into Cblocation (locationId,location) values (7,'KANO-NBS')
insert into Cblocation (locationId,location) values (8,'KANO-NBSKANO-AFEX')

create table Cbyear (
    yearId int not null
        constraint pk_Cbyear primary key,
    yeear int not null
)
insert into Cbyear (yearId,yeear) values (1,2014)
insert into Cbyear (yearId,yeear) values (2,2015) 
insert into Cbyear (yearId,yeear) values (3,2016) 
insert into Cbyear (yearId,yeear) values (4,2017) 
insert into Cbyear (yearId,yeear) values (5,2018) 
insert into Cbyear (yearId,yeear) values (6,2019) 
insert into Cbyear (yearId,yeear) values (7,2020)
insert into Cbyear (yearId,yeear) values (8,2021)

create table Cbplantingtype (
    pltypeId int not null
        constraint pk_Cbplantingtype primary key,
    pltype varchar(35) not null
)
insert into Cbplantingtype (pltypeId,pltype) values (1,'RAINNING SEASON')
insert into Cbplantingtype (pltypeId,pltype) values (2,'DRY SEASON')

create table Cbuser (
    userId bigint not null
        constraint pk_Cbuser primary key,
    username varchar(15) not null,
    passwd varchar(15) not null,
    role varchar(15) not null
)


insert into Cbuser(userId,username,passwd,role) values (8223372036854775806,'dao','dao123','ADMINISTRATOR')

create table Cbloguser (
    loguserId varchar(19) not null
        constraint pk_Cbloguser primary key,
    userId bigint not null; -- CONSTRAINT FK_Cbloguser REFERENCES Cbuser,
    logsummary varchar(100) not null DEFAULT ' ',
    logdetails long varchar not null DEFAULT ' '
)


create table Cbquantity (
    quantityId int not null GENERATED ALWAYS AS IDENTITY
        (START WITH 100001, INCREMENT BY 1)
        constraint pk_Cbquantity primary key,
    quantity1 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty1 CHECK ( quantity1 > 0 ),
    quantity2 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty2 CHECK ( quantity2 > 0 ),
    quantity3 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty3 CHECK ( quantity3 > 0 ),
    quantity4 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty4 CHECK ( quantity4 > 0 ),
    quantity5 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty5 CHECK ( quantity5 > 0 ),
    quantity6 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty6 CHECK ( quantity6 > 0 ),
    quantity7 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty7 CHECK ( quantity7 > 0 ),
    quantity8 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty8 CHECK ( quantity8 > 0 ),
    quantity9 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty9 CHECK ( quantity9 > 0 ),
    quantity10 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty10 CHECK ( quantity10 > 0 ),
    quantity11 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty11 CHECK ( quantity11 > 0 ),
    quantity12 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty12 CHECK ( quantity12 > 0 ),
    quantity13 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty13 CHECK ( quantity13 > 0 ),
    quantity14 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty14 CHECK ( quantity14 > 0 ),
    quantity15 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty15 CHECK ( quantity15 > 0 ),
    quantity16 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty16 CHECK ( quantity16 > 0 ),
    quantity17 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty17 CHECK ( quantity17 > 0 ),
    quantity18 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty18 CHECK ( quantity18 > 0 ),
    quantity19 decimal(8,2) not null CONSTRAINT CK_Cbquantity_qty19 CHECK ( quantity19 > 0 )
)




create table Cbvarrate (
    varrateId int not null GENERATED ALWAYS AS IDENTITY
        (START WITH 100001, INCREMENT BY 1)
        constraint pk_Cbvarrate primary key,
    cropId int not null,
    locationId int not null,
    yearId int not null,
    pltypeId int not null,
    varrate1 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate1 CHECK ( varrate1 > 0 ),
    varrate2 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate2 CHECK ( varrate2 > 0 ),
    varrate3 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate3 CHECK ( varrate3 > 0 ),
    varrate4 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate4 CHECK ( varrate4 > 0 ),
    varrate5 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate5 CHECK ( varrate5 > 0 ),
    varrate6 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate6 CHECK ( varrate6 > 0 ),
    varrate7 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate7 CHECK ( varrate7 > 0 ),
    varrate8 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate8 CHECK ( varrate8 > 0 ),
    varrate9 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate9 CHECK ( varrate9 > 0 ),
    varrate10 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate10 CHECK ( varrate10 > 0 ),
    varrate11 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate11 CHECK ( varrate11 > 0 ),
    varrate12 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate12 CHECK ( varrate12 > 0 ),
    varrate13 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate13 CHECK ( varrate13 > 0 ),
    varrate14 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate14 CHECK ( varrate14 > 0 ),
    varrate15 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate15 CHECK ( varrate15 > 0 ),
    varrate16 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate16 CHECK ( varrate16 > 0 ),
    varrate17 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate17 CHECK ( varrate17 > 0 ),
    varrate18 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate18 CHECK ( varrate18 > 0 ),
    varrate19 decimal(8,2) not null CONSTRAINT CK_Cbvarrate_vrate19 CHECK ( varrate19 > 0 )
)

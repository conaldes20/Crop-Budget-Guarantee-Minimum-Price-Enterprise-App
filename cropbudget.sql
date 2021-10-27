create table Cbcrop (
    cropId int not null,
    crop varchar(45) not null,
    PRIMARY KEY (cropId)
);
insert into Cbcrop (cropId,crop) values (1,'MAIZE - GRAIN (WHITE)');
insert into Cbcrop (cropId,crop) values (2,'MIZE - GRAIN (YELLOW)'); 
insert into Cbcrop (cropId,crop) values (3,'BEANS - BROWN'); 
insert into Cbcrop (cropId,crop) values (4,'BEANS - WHITE'); 
insert into Cbcrop (cropId,crop) values (5,'RICE - LOCAL'); 
insert into Cbcrop (cropId,crop) values (6,'PADDY RICE'); 
insert into Cbcrop (cropId,crop) values (7,'RICE - IMPORTED');
insert into Cbcrop (cropId,crop) values (8,'SORGHUM');
insert into Cbcrop (cropId,crop) values (9,'COWPEAS');
insert into Cbcrop (cropId,crop) values (10,'MILLET');
insert into Cbcrop (cropId,crop) values (11,'SOYA BEANS');

create table Cblocation (
    locationId int not null,
    location varchar(75) not null,
    PRIMARY KEY (locationId)
);
insert into Cblocation (locationId,location) values (1,'NORTH-CENTRAL');
insert into Cblocation (locationId,location) values (2,'NORTH-EAST'); 
insert into Cblocation (locationId,location) values (3,'NORTH-WEST'); 
insert into Cblocation (locationId,location) values (4,'SOUTH-EAST'); 
insert into Cblocation (locationId,location) values (5,'SOUTH-WEST'); 
insert into Cblocation (locationId,location) values (6,'SOUTH-SOUTH'); 
insert into Cblocation (locationId,location) values (7,'KANO-NBS');
insert into Cblocation (locationId,location) values (8,'KANO-NBSKANO-AFEX');

create table Cbyear (
    yearId int not null,
    yeear int not null,
    PRIMARY KEY (yearId)
);
insert into Cbyear (yearId,yeear) values (1,2017);
insert into Cbyear (yearId,yeear) values (2,2018);
insert into Cbyear (yearId,yeear) values (3,2019); 
insert into Cbyear (yearId,yeear) values (4,2020);
insert into Cbyear (yearId,yeear) values (5,2021);
insert into Cbyear (yearId,yeear) values (6,2022);
insert into Cbyear (yearId,yeear) values (7,2023);
insert into Cbyear (yearId,yeear) values (8,2024);

create table Cbplantingtype (
    pltypeId int not null,
    pltype varchar(35) not null,
    PRIMARY KEY (pltypeId)
);

insert into Cbplantingtype (pltypeId,pltype) values (1,'RAINNING SEASON');
insert into Cbplantingtype (pltypeId,pltype) values (2,'DRY SEASON');
insert into Cbplantingtype (pltypeId,pltype) values (3,'IRRIGATION');
insert into Cbplantingtype (pltypeId,pltype) values (4,'FADAMA');

create table cbuser (
    userId varchar(25) not null,
    username varchar(15) not null,
    passwd varchar(15) not null,
    urole varchar(15) not null,
    PRIMARY KEY (userId)
);

ALTER TABLE cbuser
ADD CONSTRAINT UQ_cbuser UNIQUE (username);

ALTER TABLE cbuser
ADD CONSTRAINT UQ_userpwd UNIQUE (passwd);

insert into cbuser(userId,username,passwd,urole) values (8223372036854775806,'dao','dao123','ADMINISTRATOR');

create table cbloguser (
    loguserId varchar(25) not null,
    userId varchar(25) not null, 
    logsummary varchar(100) DEFAULT ' ' not null,
    logdetails varchar(400) DEFAULT ' ' not null,
    PRIMARY KEY (loguserId),
    CONSTRAINT fk_user_ID FOREIGN KEY (userId) REFERENCES cbuser (userId)
);

create table Cbquantity (
    quantityId int(11) NOT NULL AUTO_INCREMENT,
    quantity1 decimal(8,2) not null CHECK ( quantity1 > 0),
    quantity2 decimal(8,2) not null CHECK ( quantity2 > 0 ),
    quantity3 decimal(8,2) not null CHECK ( quantity3 > 0 ),
    quantity4 decimal(8,2) not null CHECK ( quantity4 > 0 ),
    quantity5 decimal(8,2) not null CHECK ( quantity5 > 0 ),
    quantity6 decimal(8,2) not null CHECK ( quantity6 > 0 ),
    quantity7 decimal(8,2) not null CHECK ( quantity7 > 0 ),
    quantity8 decimal(8,2) not null CHECK ( quantity8 > 0 ),
    quantity9 decimal(8,2) not null CHECK ( quantity9 > 0 ),
    quantity10 decimal(8,2) not null CHECK ( quantity10 > 0 ),
    quantity11 decimal(8,2) not null CHECK ( quantity11 > 0 ),
    quantity12 decimal(8,2) not null CHECK ( quantity12 > 0 ),
    quantity13 decimal(8,2) not null CHECK ( quantity13 > 0 ),
    quantity14 decimal(8,2) not null CHECK ( quantity14 > 0 ),
    quantity15 decimal(8,2) not null CHECK ( quantity15 > 0 ),
    quantity16 decimal(8,2) not null CHECK ( quantity16 > 0 ),
    quantity17 decimal(8,2) not null CHECK ( quantity17 > 0 ),
    quantity18 decimal(8,2) not null CHECK ( quantity18 > 0 ),
    quantity19 decimal(8,2) not null CHECK ( quantity19 > 0 ),
    PRIMARY KEY (quantityId)
);

ALTER TABLE Cbquantity AUTO_INCREMENT = 10000000101;

create table Cbvarrate (
    varrateId int(11) NOT NULL AUTO_INCREMENT,
    cropId int not null,
    locationId int not null,
    yearId int not null,
    pltypeId int not null,
    varrate1 decimal(8,2) not null CHECK ( varrate1 > 0 ),
    varrate2 decimal(8,2) not null CHECK ( varrate2 > 0 ),
    varrate3 decimal(8,2) not null CHECK ( varrate3 > 0 ),
    varrate4 decimal(8,2) not null CHECK ( varrate4 > 0 ),
    varrate5 decimal(8,2) not null CHECK ( varrate5 > 0 ),
    varrate6 decimal(8,2) not null CHECK ( varrate6 > 0 ),
    varrate7 decimal(8,2) not null CHECK ( varrate7 > 0 ),
    varrate8 decimal(8,2) not null CHECK ( varrate8 > 0 ),
    varrate9 decimal(8,2) not null CHECK ( varrate9 > 0 ),
    varrate10 decimal(8,2) not null CHECK ( varrate10 > 0 ),
    varrate11 decimal(8,2) not null CHECK ( varrate11 > 0 ),
    varrate12 decimal(8,2) not null CHECK ( varrate12 > 0 ),
    varrate13 decimal(8,2) not null CHECK ( varrate13 > 0 ),
    varrate14 decimal(8,2) not null CHECK ( varrate14 > 0 ),
    varrate15 decimal(8,2) not null CHECK ( varrate15 > 0 ),
    varrate16 decimal(8,2) not null CHECK ( varrate16 > 0 ),
    varrate17 decimal(8,2) not null CHECK ( varrate17 > 0 ),
    varrate18 decimal(8,2) not null CHECK ( varrate18 > 0 ),
    varrate19 decimal(8,2) not null CHECK ( varrate19 > 0 ),
    PRIMARY KEY (varrateId)
);

ALTER TABLE Cbquantity AUTO_INCREMENT = 10000000001;
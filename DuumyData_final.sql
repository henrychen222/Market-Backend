USE Market_backend

IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('Manufacturer'))
BEGIN;
    DROP TABLE [Manufacturer];
END;
GO

CREATE TABLE [Manufacturer]
(
    [ManufacturerID] INTEGER NOT NULL IDENTITY(1, 1),
    [Department] VARCHAR(255) NULL,
    [Phone] VARCHAR(100) NULL,
    [Email] VARCHAR(255) NULL,
    [WebUrl] VARCHAR(50) NULL,
    PRIMARY KEY ([ManufacturerID])
);
GO

IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('Buyer'))
BEGIN;
    DROP TABLE [Buyer];
END;
GO

CREATE TABLE [Buyer]
(
    [BuyerID] INTEGER NOT NULL IDENTITY(1, 1),
    [email] VARCHAR(255) NULL,
    [firstname] VARCHAR(100) NULL,
    [lastname] VARCHAR(255) NULL,
    [username] VARCHAR(100) NULL,
    [password] VARCHAR(100) NULL,
    PRIMARY KEY ([BuyerID])
);
GO

IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('Sales'))
BEGIN;
    DROP TABLE [Sales];
END;
GO

CREATE TABLE [Sales]
(
    [SalesID] INTEGER NOT NULL IDENTITY(1, 1),
    [Name] VARCHAR(255) NULL,
    [Phone] VARCHAR(100) NULL,
    [Email] VARCHAR(255) NULL,
    [ManufacturerID] INTEGER NULL,
    [WebUrl] VARCHAR(50) NULL,
    PRIMARY KEY ([SalesID])
);
GO

IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('Product'))
BEGIN;
    DROP TABLE [Product];
END;
GO

CREATE TABLE [Product]
(
    [ProductID] INTEGER NOT NULL IDENTITY(1, 1),
    [ProductName] VARCHAR(255) NULL,
    [ProductDescription] VARCHAR(MAX) NULL,
    [ProductPrice] INTEGER NULL,
    [DocumentXML] VARCHAR(255) NULL,
    [AttributeXML] VARCHAR(255) NULL,
    [ManufacturerID] INTEGER NULL,
    [SalesID] INTEGER NULL,
    [SubCategoryID] INTEGER NULL,
    [Details] VARCHAR(MAX) NULL,
    PRIMARY KEY ([ProductID])
);
GO

IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('Category'))
BEGIN;
    DROP TABLE [Category];
END;
GO

CREATE TABLE [Category]
(
    [CategoryID] INTEGER NOT NULL IDENTITY(1, 1),
    [CategoryName] VARCHAR(100) NULL,
    PRIMARY KEY ([CategoryID])
);
GO

IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('SubCategory'))
BEGIN;
    DROP TABLE [SubCategory];
END;
GO

CREATE TABLE [SubCategory]
(
    [SubCategoryID] INTEGER NOT NULL IDENTITY(1, 1),
    [SubCategoryName] VARCHAR(255) NULL,
    [CategoryID] INTEGER NULL,
    PRIMARY KEY ([SubCategoryID])
);
GO

USE Market_backend
IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('AttributeType'))
BEGIN;
    DROP TABLE [AttributeType];
END;
GO

CREATE TABLE [AttributeType]
(
    [AttributeTypeID] INTEGER NOT NULL IDENTITY(1, 1),
    [AttributeTypeName] VARCHAR(100) NULL,
    PRIMARY KEY ([AttributeTypeID])
);
GO

IF EXISTS(SELECT 1
FROM sys.tables
WHERE object_id = OBJECT_ID('Attribute'))
BEGIN;
    DROP TABLE [Attribute];
END;
GO

CREATE TABLE [Attribute]
(
    [AttributeID] INTEGER NOT NULL IDENTITY(1, 1),
    [AttributeName] VARCHAR(255) NULL,
    [IsRange] Bit NOT NUll,
    [MinValue] INTEGER NULL,
    [MaxValue] INTEGER NULL,
    [AttributeTypeID] INTEGER NULL,
    [SubCategoryID] INTEGER NULL,
    PRIMARY KEY ([AttributeID])
);
GO

INSERT INTO AttributeType
    ([AttributeTypeName])
VALUES('Product Type'),
    ('Technical Specification'),
    ('Brand'),
    ('Past Selections'),
    ('Certification'),
    ('Other');

INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Use Type', 'False', NULL, NULL, 1, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Application', 'False', NULL, NULL, 1, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Mounting Location', 'False', NULL, NULL, 1, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Accessories', 'False', NULL, NULL, 1, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Model_Year.s', 'True', 2010, 2016, 1, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Airflow.CFM', 'True', 5000, 10000, 2, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Power.W', 'True', 9.84, 65, 2, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Sound_at_max_speed.dBA', 'True', 20, 35, 2, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Fan_Sweep_Diameter.in', 'True', 18, 60, 2, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Height.in', 'True', 12, 78, 2, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Select Brand', 'False', NULL, NULL, 3, 1);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('With the words', 'False', NULL, NULL, 5, 1);

INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Use Type', 'False', NULL, NULL, 1, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Application', 'False', NULL, NULL, 1, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Mounting Location', 'False', NULL, NULL, 1, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Accessories', 'False', NULL, NULL, 1, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Model_Year.s', 'True', 2010, 2016, 1, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Airflow.CFM', 'True', 5000, 10000, 2, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Power.W', 'True', 9.84, 65, 2, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Sound_at_max_speed.dBA', 'True', 20, 35, 2, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Fan_Sweep_Diameter.in', 'True', 18, 60, 2, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Height.in', 'True', 12, 78, 2, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Select Brand', 'False', NULL, NULL, 3, 2);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('With the words', 'False', NULL, NULL, 5, 1);
INSERT INTO Buyer
    ([email], [firstname], [lastname], [password], [username])
VALUES('12345@gamil.com', 'barF', 'fooL', '123456', 'Alex');

--Newly added Wei
--SubCate 3 
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Speed', 'True', 10, 100, 2, 3);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('LowerThresholdNonCritical', 'True', 190, 1020, 2, 3);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('LowerThresholdCritical', 'True', 90, 920, 2, 3);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('LowerThresholdFatal', 'True', 20, 820, 2, 3);

--SubCate 4 
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('MinReadingRange', 'True', 100, 1000, 2, 4);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('MaxReadingRange', 'True', 200, 1100, 2, 4);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('PhysicalContext', 'True', 150, 950, 2, 4);

--SubCate 5
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('Reading', 'True', 100, 1000, 2, 5);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('ReadingUnits', 'True', 200, 1100, 2, 5);
INSERT INTO Attribute
    ([AttributeName],[IsRange],[MinValue],[MaxValue],[AttributeTypeID],[SubCategoryID])
VALUES('StatusHealth', 'True', 150, 950, 2, 5);


INSERT INTO Category
    ([CategoryName])
VALUES('Mechanical');
INSERT INTO SubCategory
    ([SubCategoryName],[CategoryID])
VALUES('HAVC Fans', 1),
    ('Window Fans', 1),
    ('Ceiling Fans', 1),
    ('Industrial Fans', 1),
    ('Fighting Fans', 1);

INSERT INTO Manufacturer
    ([Department],[Phone],[Email],[WebUrl])
VALUES('Manufacturer1', '1-604-105-1948', 'non.enim.Mauris@duinec.co.uk', 'www.Manufacturer1.com'),
    ('Manufacturer2', '1-604-105-1948', 'non.enim.Mauris@duinec.co.uk', 'www.Manufacturer2.com'),
    ('Manufacturer3', '1-604-105-1948', 'non.enim.Mauris@duinec.co.uk', 'www.Manufacturer3.com');


INSERT INTO Sales
    ([Name],[Phone],[Email],[ManufacturerID],[WebUrl])
VALUES('Sale1-Cate1', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 1, 'www.Sale1-Cate1.com'),
    ('Sale2-Cate1', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 1, 'www.Sale2-Cate1.com'),
    ('Sale2-Cate1', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 1, 'www.Sale2-Cate1.com'),
    ('Sale1-Cate2', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 2, 'www.Sale1-Cate2.com'),
    ('Sale2-Cate2', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 2, 'www.Sale2-Cate2.com'),
    ('Sale3-Cate2', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 2, 'www.Sale3-Cate2.com'),
    ('Sale1-Cate3', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 3, 'www.Sale1-Cate3.com'),
    ('Sale2-Cate3', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 3, 'www.Sale2-Cate3.com'),
    ('Sale3-Cate3', '1-433-258-7247', 'tortor.dictum.eu@laciniaSed.ca', 3, 'www.Sale3-Cate3.com');


INSERT INTO Product
    ([ProductName],[ProductDescription],
    [ProductPrice],[DocumentXML],[AttributeXML],
    [ManufacturerID],[SalesID],[SubCategoryID],[Details])
VALUES
    -- SubCate1
    ('Dominic', 'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        123, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2010</Model_Year.s><Airflow.CFM>6000</Airflow.CFM><Power.W>20</Power.W><Sound_at_max_speed.dBA>35</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>60</Fan_Sweep_Diameter.in><Height.in>15</Height.in></attribute>',
        1, 1, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Atkinson', 'Emerson/Luray Eco Series/CF860',
        234, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2011</Model_Year.s><Airflow.CFM>5050</Airflow.CFM><Power.W>10</Power.W><Sound_at_max_speed.dBA>25</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>50</Fan_Sweep_Diameter.in><Height.in>15</Height.in></attribute>',
        1, 2, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Lorem', 'Minka/Aviation Series/F853-RW',
        342, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2014</Model_Year.s><Airflow.CFM>7000</Airflow.CFM><Power.W>30</Power.W><Sound_at_max_speed.dBA>35</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>70</Fan_Sweep_Diameter.in><Height.in>25</Height.in></attribute>',
        1, 3, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Lpsum', 'Westinghouse/Industrial Ceiling Fan/78003',
        234, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2013</Model_Year.s><Airflow.CFM>8000</Airflow.CFM><Power.W>40</Power.W><Sound_at_max_speed.dBA>25</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>20</Fan_Sweep_Diameter.in><Height.in>35</Height.in></attribute>',
        2, 1, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Consectetuer', 'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        345, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2012</Model_Year.s><Airflow.CFM>9080</Airflow.CFM><Power.W>50</Power.W><Sound_at_max_speed.dBA>30</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>40</Fan_Sweep_Diameter.in><Height.in>45</Height.in></attribute>',
        2, 2, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Nunc',
        'Minka/Aviation Series/F853-RW',
        564, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2011</Model_Year.s><Airflow.CFM>10000</Airflow.CFM><Power.W>60</Power.W><Sound_at_max_speed.dBA>20</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>60</Fan_Sweep_Diameter.in><Height.in>55</Height.in></attribute>',
        2, 3, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Aliquam',
        'Emerson/Luray Eco Series/CF860',
        345, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2015</Model_Year.s><Airflow.CFM>7050</Airflow.CFM><Power.W>64</Power.W><Sound_at_max_speed.dBA>35</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>55</Fan_Sweep_Diameter.in><Height.in>66</Height.in></attribute>',
        3, 1, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Dapibus',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        757, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2016</Model_Year.s><Airflow.CFM>6060</Airflow.CFM><Power.W>64</Power.W><Sound_at_max_speed.dBA>22</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>33</Fan_Sweep_Diameter.in><Height.in>77</Height.in></attribute>',
        3, 2, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Tortor', 'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        789, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2015</Model_Year.s><Airflow.CFM>7070</Airflow.CFM><Power.W>64</Power.W><Sound_at_max_speed.dBA>33</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>50</Fan_Sweep_Diameter.in><Height.in>66</Height.in></attribute>',
        3, 3, 1, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    -- SubCate2
    ('Dominic',
        'Minka/Aviation Series/F853-RW',
        123, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2010</Model_Year.s><Airflow.CFM>6000</Airflow.CFM><Power.W>20</Power.W><Sound_at_max_speed.dBA>35</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>60</Fan_Sweep_Diameter.in><Height.in>15</Height.in></attribute>',
        1, 1, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Atkinson',
        'Emerson/Luray Eco Series/CF860',
        234, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2011</Model_Year.s><Airflow.CFM>5050</Airflow.CFM><Power.W>10</Power.W><Sound_at_max_speed.dBA>25</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>50</Fan_Sweep_Diameter.in><Height.in>15</Height.in></attribute>',
        1, 2, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Lorem',
        'Minka/Aviation Series/F853-RW',
        342, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2014</Model_Year.s><Airflow.CFM>7000</Airflow.CFM><Power.W>30</Power.W><Sound_at_max_speed.dBA>35</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>70</Fan_Sweep_Diameter.in><Height.in>25</Height.in></attribute>',
        1, 3, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Lpsum',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        234, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2013</Model_Year.s><Airflow.CFM>8000</Airflow.CFM><Power.W>40</Power.W><Sound_at_max_speed.dBA>25</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>20</Fan_Sweep_Diameter.in><Height.in>35</Height.in></attribute>',
        2, 1, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Consectetuer',
        'Westinghouse/Industrial Ceiling Fan/78003',
        345, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2012</Model_Year.s><Airflow.CFM>9080</Airflow.CFM><Power.W>50</Power.W><Sound_at_max_speed.dBA>30</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>40</Fan_Sweep_Diameter.in><Height.in>45</Height.in></attribute>',
        2, 2, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Nunc',
        'Minka/Aviation Series/F853-RW',
        564, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2011</Model_Year.s><Airflow.CFM>10000</Airflow.CFM><Power.W>60</Power.W><Sound_at_max_speed.dBA>20</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>60</Fan_Sweep_Diameter.in><Height.in>55</Height.in></attribute>',
        2, 3, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Aliquam',
        'Emerson/Luray Eco Series/CF860',
        345, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2015</Model_Year.s><Airflow.CFM>7050</Airflow.CFM><Power.W>64</Power.W><Sound_at_max_speed.dBA>35</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>55</Fan_Sweep_Diameter.in><Height.in>66</Height.in></attribute>',
        3, 1, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Dapibus',
        'Westinghouse/Industrial Ceiling Fan/78003',
        757, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2016</Model_Year.s><Airflow.CFM>6060</Airflow.CFM><Power.W>64</Power.W><Sound_at_max_speed.dBA>22</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>33</Fan_Sweep_Diameter.in><Height.in>77</Height.in></attribute>',
        3, 2, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Tortor',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        789, '<doc>doccuments</doc>', '<attribute><Model_Year.s>2015</Model_Year.s><Airflow.CFM>7070</Airflow.CFM><Power.W>64</Power.W><Sound_at_max_speed.dBA>33</Sound_at_max_speed.dBA><Fan_Sweep_Diameter.in>50</Fan_Sweep_Diameter.in><Height.in>66</Height.in></attribute>',
        3, 3, 2, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),

    -- SubCate3
    ('Minka-Aire',
        'Westinghouse/Industrial Ceiling Fan/78003',
        123, '<doc>doccuments</doc>', '<attribute><Speed>10</Speed><LowerThresholdNonCritical>430</LowerThresholdNonCritical><LowerThresholdCritical>230</LowerThresholdCritical><LowerThresholdFatal>130</LowerThresholdFatal></attribute>',
        1, 1, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Casablanca',
        'Emerson/Luray Eco Series/CF860',
        567, '<doc>doccuments</doc>', '<attribute><Speed>20</Speed><LowerThresholdNonCritical>790</LowerThresholdNonCritical><LowerThresholdCritical>690</LowerThresholdCritical><LowerThresholdFatal>590</LowerThresholdFatal></attribute>',
        1, 2, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Hunter',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        444, '<doc>doccuments</doc>', '<attribute><Speed>30</Speed><LowerThresholdNonCritical>820</LowerThresholdNonCritical><LowerThresholdCritical>720</LowerThresholdCritical><LowerThresholdFatal>620</LowerThresholdFatal></attribute>',
        2, 1, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Emerson',
        'Emerson/Luray Eco Series/CF860',
        296, '<doc>doccuments</doc>', '<attribute><Speed>40</Speed><LowerThresholdNonCritical>640</LowerThresholdNonCritical><LowerThresholdCritical>540</LowerThresholdCritical><LowerThresholdFatal>440</LowerThresholdFatal></attribute>',
        2, 2, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Monte',
        'Minka/Aviation Series/F853-RW',
        743, '<doc>doccuments</doc>', '<attribute><Speed>50</Speed><LowerThresholdNonCritical>310</LowerThresholdNonCritical><LowerThresholdCritical>210</LowerThresholdCritical><LowerThresholdFatal>110</LowerThresholdFatal></attribute>',
        3, 1, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Westinghouse',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        838, '<doc>doccuments</doc>', '<attribute><Speed>60</Speed><LowerThresholdNonCritical>290</LowerThresholdNonCritical><LowerThresholdCritical>180</LowerThresholdCritical><LowerThresholdFatal>90</LowerThresholdFatal></attribute>',
        3, 2, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Carlo',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        996, '<doc>doccuments</doc>', '<attribute><Speed>70</Speed><LowerThresholdNonCritical>570</LowerThresholdNonCritical><LowerThresholdCritical>470</LowerThresholdCritical><LowerThresholdFatal>370</LowerThresholdFatal></attribute>',
        3, 3, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Fanimation',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        522, '<doc>doccuments</doc>', '<attribute><Speed>80</Speed><LowerThresholdNonCritical>190</LowerThresholdNonCritical><LowerThresholdCritical>90</LowerThresholdCritical><LowerThresholdFatal>20</LowerThresholdFatal></attribute>',
        1, 3, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Craftman',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        822, '<doc>doccuments</doc>', '<attribute><Speed>90</Speed><LowerThresholdNonCritical>990</LowerThresholdNonCritical><LowerThresholdCritical>890</LowerThresholdCritical><LowerThresholdFatal>790</LowerThresholdFatal></attribute>',
        2, 3, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Quorum',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        145, '<doc>doccuments</doc>', '<attribute><Speed>100</Speed><LowerThresholdNonCritical>1020</LowerThresholdNonCritical><LowerThresholdCritical>920</LowerThresholdCritical><LowerThresholdFatal>820</LowerThresholdFatal></attribute>',
        1, 1, 3, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),

    -- SubCate4
    ('Minka-Aire',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        123, '<doc>doccuments</doc>', '<attribute><MinReadingRange>100</MinReadingRange><MaxReadingRange>200</MaxReadingRange><PhysicalContext>50</PhysicalContext></attribute>',
        1, 1, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Casablanca',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        567, '<doc>doccuments</doc>', '<attribute><MinReadingRange>200</MinReadingRange><MaxReadingRange>300</MaxReadingRange><PhysicalContext>150</PhysicalContext></attribute>',
        1, 2, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Hunter',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        444, '<doc>doccuments</doc>', '<attribute><MinReadingRange>300</MinReadingRange><MaxReadingRange>400</MaxReadingRange><PhysicalContext>250</PhysicalContext></attribute>',
        1, 3, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Emerson',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        296, '<doc>doccuments</doc>', '<attribute><MinReadingRange>400</MinReadingRange><MaxReadingRange>500</MaxReadingRange><PhysicalContext>350</PhysicalContext></attribute>',
        1, 4, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Monte',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        743, '<doc>doccuments</doc>', '<attribute><MinReadingRange>500</MinReadingRange><MaxReadingRange>600</MaxReadingRange><PhysicalContext>450</PhysicalContext></attribute>',
        2, 1, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Westinghouse',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        838, '<doc>doccuments</doc>', '<attribute><MinReadingRange>600</MinReadingRange><MaxReadingRange>700</MaxReadingRange><PhysicalContext>550</PhysicalContext></attribute>',
        2, 2, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Carlo',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        996, '<doc>doccuments</doc>', '<attribute><MinReadingRange>700</MinReadingRange><MaxReadingRange>800</MaxReadingRange><PhysicalContext>650</PhysicalContext></attribute>',
        2, 3, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Fanimation',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        522, '<doc>doccuments</doc>', '<attribute><MinReadingRange>800</MinReadingRange><MaxReadingRange>900</MaxReadingRange><PhysicalContext>750</PhysicalContext></attribute>',
        2, 4, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Craftman',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        822, '<doc>doccuments</doc>', '<attribute><MinReadingRange>900</MinReadingRange><MaxReadingRange>1000</MaxReadingRange><PhysicalContext>850</PhysicalContext></attribute>',
        3, 1, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Quorum',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        145, '<doc>doccuments</doc>', '<attribute><MinReadingRange>1000</MinReadingRange><MaxReadingRange>1100</MaxReadingRange><PhysicalContext>950</PhysicalContext></attribute>',
        3, 2, 4, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam')
,
    -- SubCate5
    ('Minka-Aire',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        123, '<doc>doccuments</doc>', '<attribute><Reading>100</Reading><ReadingUnits>200</ReadingUnits><StatusHealth>50</StatusHealth></attribute>',
        1, 1, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Casablanca',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        567, '<doc>doccuments</doc>', '<attribute><Reading>200</Reading><ReadingUnits>300</ReadingUnits><StatusHealth>150</StatusHealth></attribute>',
        1, 2, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Hunter',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        444, '<doc>doccuments</doc>', '<attribute><Reading>300</Reading><ReadingUnits>400</ReadingUnits><StatusHealth>250</StatusHealth></attribute>',
        1, 3, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Emerson',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        296, '<doc>doccuments</doc>', '<attribute><Reading>400</Reading><ReadingUnits>500</ReadingUnits><StatusHealth>350</StatusHealth></attribute>',
        1, 4, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Monte',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        743, '<doc>doccuments</doc>', '<attribute><Reading>500</Reading><ReadingUnits>600</ReadingUnits><StatusHealth>450</StatusHealth></attribute>',
        2, 1, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Westinghouse',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        838, '<doc>doccuments</doc>', '<attribute><Reading>600</Reading><ReadingUnits>700</ReadingUnits><StatusHealth>550</StatusHealth></attribute>',
        2, 2, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Carlo',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        996, '<doc>doccuments</doc>', '<attribute><Reading>700</Reading><ReadingUnits>800</ReadingUnits><StatusHealth>650</StatusHealth></attribute>',
        2, 3, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Fanimation',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        522, '<doc>doccuments</doc>', '<attribute><Reading>800</Reading><ReadingUnits>900</ReadingUnits><StatusHealth>750</StatusHealth></attribute>',
        2, 4, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Craftman',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        822, '<doc>doccuments</doc>', '<attribute><Reading>900</Reading><ReadingUnits>1000</ReadingUnits><StatusHealth>850</StatusHealth></attribute>',
        3, 1, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam'),
    ('Quorum',
        'Big Ass/Haiku H Series/S3150-S0-BC-04-01-C-01',
        145, '<doc>doccuments</doc>', '<attribute><Reading>1000</Reading><ReadingUnits>1100</ReadingUnits><StatusHealth>950</StatusHealth></attribute>',
        3, 2, 5, 'tortor at risus. Nunc ac sem ut dolor dapibus gravida. Aliquam')



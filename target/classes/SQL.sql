create database Policy;

create table Policy(
Id INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
StartDate  DATE  NOT NULL,
ExpiryDate DATE  NOT NULL,
PolicyOwner nvarchar(8) NOT NULL,
EngineNo nvarchar(30) NOT NULL,
ChassisNo nvarchar(30) NOT NULL,
VehicleNo nvarchar(30) NOT NULL,
BillingCurrency nvarchar(30) NOT NULL,
SumInsured NUMERIC(17,2) NOT NULL,
Rate NUMERIC(7,5) NOT NULL,
AnnualPremium NUMERIC(17,2) NOT NULL,
PostedPremium NUMERIC(17,2) NOT NULL,
Status nvarchar(8) NOT NULL,

);
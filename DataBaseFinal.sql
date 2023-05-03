-- Creating Data Base
create database tech_yard;

-- Using Data Base
use tech_yard;

-- Create User table
create table User_Details (
	U_Name varchar(30) not null,
    U_Age int not null,
    U_Email varchar(100) not null,
    U_Contact varchar(12) not null,
    U_Password varchar(12) not null,
    U_HouseNo int not null,
    U_Street varchar(50) not null,
    U_City varchar(50) not null,
    U_State varchar(50) not null,
    U_Pincode varchar(10) not null,
    primary key (U_Email)
);

-- Create Admin table
create table Admin_Details(
	A_Name varchar(20) not null,
    A_Email varchar(100) not null,
    A_Contact varchar(12) not null,
    A_Password varchar(12) not null,
    primary key (A_Email)
);

insert into admin_details values
("Vikas Gupta", "adminvikas@gmail.com", "7011641548", "adminvikas"),
("Parveen Mittal", "adminparveen@gmail.com", "8802227570", "adminparveen"),
("Mamraj Gupta", "adminmamraj@gamil.com", "9211345738", "adminmamraj");


-- Create Product table
create table Product_List(
	P_Name varchar(30) not null,
    P_Id varchar(30) not null,
    P_Price int not null,
    P_Image varchar(50) not null,
    P_Info varchar(250) not null,
    primary key (P_Id)
);

-- Create Feed Back table
create table Feed_Back_List(
	F_Id int auto_increment not null,
    U_Email varchar(100) not null,
    F_Comment varchar(150) not null,
    primary key (F_Id),
    foreign key (U_Email) references User_Details(U_Email)
);

-- Create Cart table
create table Cart_List (
	C_Id int auto_increment,
    U_Email varchar(100) not null,
    P_Id varchar(20) not null,
    primary key (C_Id),
    foreign key (U_Email) references User_Details(U_Email),
    foreign key (P_Id) references Product_List(P_Id)
);

-- Create Order table
create table Order_List(
	O_Id int not null auto_increment,
    U_Email varchar(100) not null,
    P_Id varchar(20) not null,
    Date_Of_Booking varchar(20) not null,
    Date_Of_Delivery varchar(20) not null,
    primary key (O_Id),
    foreign key (U_Email) references User_Details(U_Email),
    foreign key (P_Id) references Product_List(P_Id)
);

-- Create Cancel order table
create table Cancel_Details(
	C_Id int auto_increment not null,
    U_Email varchar(100) not null,
    P_Id varchar(20) not null,
    C_Reason varchar(150) not null,
    C_Date_Of_Cancel varchar(20) not null,
    primary key (C_Id),
    foreign key (U_Email) references User_Details(U_Email),
    foreign key (P_Id) references Product_List(P_Id)
);

-- Create Payment table
create table Payment_Details(
	Pay_Id int auto_increment not null,
    U_Email varchar(100) not null,
    O_Id int not null,
    P_Id varchar(20) not null,
    Pay_Status boolean not null,
    primary key (Pay_Id),
    foreign key (U_Email) references User_Details(U_Email),
    foreign key (P_Id) references Product_List(P_Id),
    foreign key (O_Id) references Order_List(O_Id) on delete cascade
);

-- Create Delivery table
create table Delivery_Details(
	D_Id int not null auto_increment,
    U_Email varchar(100) not null,
    P_Id varchar(20) not null,
    O_Id int not null,
    Date_of_Delivery varchar(20) not null,
    D_Status boolean not null,
    primary key (D_Id),
    foreign key (U_Email) references User_Details(U_Email),
    foreign key (P_Id) references Product_List(P_Id),
    foreign key (O_Id) references Order_List(O_Id) on delete cascade
);
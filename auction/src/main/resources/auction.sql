DROP TABLE TBL_PRODUCT_ORDER;
DROP TABLE TBL_PRODUCT_LIST;
DROP TABLE TBL_CATEGORY;
DROP TABLE TBL_USER;

CREATE TABLE TBL_USER(
	U_ID VARCHAR(20) PRIMARY KEY,
	U_PASS VARCHAR(20) NOT NULL,
	U_NAME VARCHAR(20) NOT NULL,
	U_ADDR VARCHAR(100) NOT NULL,
	U_PHONE VARCHAR(20) NOT NULL,
	U_EMAIL VARCHAR(20) NOT NULL,
	U_GENDER VARCHAR(2) NOT NULL,
	U_POINT INTEGER NOT NULL
)

INSERT INTO TBL_USER VALUES ('shin', '1234', '신동민', '서울', '010-3577-3342', 'teasdm@naver.com', '남',0);
INSERT INTO TBL_USER VALUES ('hong', '1234', '홍길동', '인천', '010-1234-5677', 'hong@naver.com', '여',0);

CREATE TABLE TBL_CATEGORY(
	C_CODE VARCHAR(20) PRIMARY KEY,
	C_NAME VARCHAR(50) NOT NULL,
	C_COUNT INTEGER NOT NULL
)

INSERT INTO TBL_CATEGORY VALUES ('C001', 'CASIO', 0);
INSERT INTO TBL_CATEGORY VALUES ('C002', 'TIME', 1);
INSERT INTO TBL_CATEGORY VALUES ('C003', 'TISSOT', 2);
INSERT INTO TBL_CATEGORY VALUES ('C004', 'D&G', 3);
INSERT INTO TBL_CATEGORY VALUES ('C005', 'DKNY', 4);
INSERT INTO TBL_CATEGORY VALUES ('C006', 'ROLEX', 5);
INSERT INTO TBL_CATEGORY VALUES ('C007', 'OMEGA', 6);
INSERT INTO TBL_CATEGORY VALUES ('C008', 'ALBA', 7);
INSERT INTO TBL_CATEGORY VALUES ('C009', '기타', 8);

CREATE TABLE TBL_PRODUCT_LIST(
	P_CODE INTEGER AUTO_INCREMENT PRIMARY KEY,
	P_S_UID VARCHAR(20) NOT NULL,
	P_B_UID VARCHAR(20),
	P_CATEGORY VARCHAR(20) NOT NULL,
	P_SNUMBER VARCHAR(50) NOT NULL,
	P_INSTANT_PRICE INTEGER,
	P_PRIMARY_PRICE INTEGER NOT NULL,
	P_CURRENT_PRICE INTEGER,
	P_CONTENT VARCHAR(100) NOT NULL,
	P_TITLE VARCHAR(50) NOT NULL,
	P_DATE VARCHAR(20) NOT NULL,
	P_DATE2 VARCHAR(20) NOT NULL,
	
	CONSTRAINT S_UID FOREIGN KEY (P_S_UID) REFERENCES TBL_USER(U_ID),
	CONSTRAINT B_UID FOREIGN KEY (P_B_UID) REFERENCES TBL_USER(U_ID),
	CONSTRAINT P_CATEGORY FOREIGN KEY (P_CATEGORY) REFERENCES TBL_CATEGORY(C_CODE)
)

CREATE TABLE TBL_PRODUCT_ORDER(
	O_CODE INTEGER AUTO_INCREMENT PRIMARY KEY,
	O_S_UID VARCHAR(20) NOT NULL,
	O_B_UID VARCHAR(20) NOT NULL,
	O_SNUMBER VARCHAR(50) NOT NULL,
	O_SELL_PRICE INTEGER NOT NULL,
	O_DATE VARCHAR(20) NOT NULL,

	CONSTRAINT BUY_S_UID FOREIGN KEY (O_S_UID) REFERENCES TBL_USER(U_ID),
	CONSTRAINT BUY_B_UID FOREIGN KEY (O_B_UID) REFERENCES TBL_USER(U_ID)
)

 ALTER TABLE TBL_PRODUCT_ORDER DROP X;
 ALTER TABLE TBL_PRODUCT_ORDER DROP Y;
 ALTER TABLE TBL_PRODUCT_LIST DROP X;
 ALTER TABLE TBL_PRODUCT_LIST DROP Y;
 
ALTER TABLE TBL_PRODUCT_ORDER ADD X DOUBLE;
ALTER TABLE TBL_PRODUCT_ORDER ADD Y DOUBLE;
ALTER TABLE TBL_PRODUCT_LIST ADD X DOUBLE;
ALTER TABLE TBL_PRODUCT_LIST ADD Y DOUBLE;
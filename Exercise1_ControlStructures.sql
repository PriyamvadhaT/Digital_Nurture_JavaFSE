CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Age NUMBER,
    Balance NUMBER(10,2),
    IsVIP VARCHAR2(5)
);

INSERT INTO Customers VALUES (101, 'Rahul', 65, 15000, 'FALSE');
INSERT INTO Customers VALUES (102, 'Priya', 45, 8000, 'FALSE');
INSERT INTO Customers VALUES (103, 'Arun', 70, 25000, 'FALSE');
INSERT INTO Customers VALUES (104, 'Meena', 35, 12000, 'FALSE');

COMMIT;

SELECT * FROM Customers;

DECLARE

    CURSOR customer_cursor IS
        SELECT CustomerID, Age
        FROM Customers;

BEGIN

    FOR cust IN customer_cursor LOOP

        IF cust.Age > 60 THEN

            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('1% Interest discount applied successfully.');

END;
/

DECLARE

    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;

BEGIN

    FOR cust IN customer_cursor LOOP

        IF cust.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');

END;
/

SELECT * FROM Customers;

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    InterestRate NUMBER(5,2),
    DueDate DATE,
    CONSTRAINT fk_customer
        FOREIGN KEY (CustomerID)
        REFERENCES Customers(CustomerID)
);

INSERT INTO Loans VALUES (1, 101, 10, DATE '2026-07-15');
INSERT INTO Loans VALUES (2, 102, 11, DATE '2026-09-20');
INSERT INTO Loans VALUES (3, 103, 9, DATE '2026-07-05');
INSERT INTO Loans VALUES (4, 104, 8, DATE '2026-08-15');

COMMIT;

SELECT * FROM Loans;

UPDATE Loans
SET DueDate = SYSDATE + 10
WHERE LoanID = 1;

UPDATE Loans
SET DueDate = SYSDATE + 20
WHERE LoanID = 3;

COMMIT;

DECLARE

    CURSOR loan_cursor IS
        SELECT c.CustomerName,
               l.LoanID,
               l.DueDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN

    FOR loan_rec IN loan_cursor LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan '
            || loan_rec.LoanID
            || ' for '
            || loan_rec.CustomerName
            || ' is due on '
            || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
        );

    END LOOP;

END;
/
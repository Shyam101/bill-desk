# bill-desk

Base url : https://bill-desk.herokuapp.com

github url: https://github.com/Shyam101/bill-desk 

## API Details
---

Path: /
<br/>
Method: get
<br/>
Returns: “hello” string
<br/>

---

Path: /bills/
<br/>
Method: post
<br/>
Returns: id of created bill
<br/>
example paylod (json):
```
{
	"billNumber" : 2223,
	"billedTo" : "Shyam Vaghela",
	"billDate" : "2021-11-20",
	"billAmount" : 23423,
	"taxAmount" : 23,
	"totalAmount" : 23453,
        "dueDate" : "2021-11-25"
}
```

---

Path: /bills/
<br/>
Method: get
<br/>
Returns: list of all bills

---

Path: /bills/{id}
<br/>
Path variable : id of bill
<br/>
Method: get
<br/>
Returns: single bill with given id or 404 NOT FOUND

---

Path: /bills/{yyyy-MM-dd}
<br/>
Path variable: due date in yyyy-MM-dd format
<br/>
Method: get
<br/>
Returns: list of all bills due on given date

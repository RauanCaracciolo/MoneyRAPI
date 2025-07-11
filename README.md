# 💰 MoneyRAPI - Personal Finance REST API

## A web application to track personal financial transactions, built using:
<br>
<p><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/html5/html5-original.svg" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/javascript/javascript-original.svg" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/css3/css3-original.svg" height="40"/>
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="40"/> </p>

> Built with Java Servlets, TailwindCSS, vanilla JavaScript and Chart.js.

---

## 🧩 Problem

Managing personal finances manually or in spreadsheets can be error-prone and time-consuming. 
Many people lack a simple and efficient system to:

- Track daily income and expenses.
- Organize transactions by categories.
- Visualize financial reports and spending behavior.

---

## 💡 Solution

**MoneyRAPI** is a RESTful API with a full web-based interface that allows users to:

- Create, update and delete transactions.
- Filter transactions by type and category.
- View a financial report with total balance, incomes, and expenses.
- Visualize income and expenses distribution by category in pie charts.

---

## ⚙️ Features

- ✅ REST API built in Java (Servlets) with Front Controller + Chain of Responsibility.
- ✅ Full CRUD operations.
- ✅ Real-time filtering and pagination of transactions.
- ✅ Editable interface with TailwindCSS.
- ✅ Data visualization using Chart.js.

---

## 💻 Screenshots (to be added)

<!-- 
![Dashboard](link)
![Report](link)
-->

---

## 🧪 Example: Report JSON

```json
{
  "totalIncome": 552.2,
  "totalExpense": 11250.43,
  "actualMoney": -10698.23,
  "categoryIncome": {
    "Grocery": 200.0,
    "job": 200.0,
    "Teste": 32.2,
    "Carro": 120.0
  },
  "categoryExpense": {
    "Carro": 11200.43,
    "Mercado": 50.0
  }
}

```


> ⚠️ **Note**: Due to an issue with Eclipse corrupting my previous project workspace, I decided to recreate the project under a new name — hence the extra **"R"** in **MoneyRAPI**.  
>  
> 🛠️ If you're interested in seeing the full development process of the original version, please visit the repository here: [github.com/RauanCaracciolo/MoneyAPI](https://github.com/RauanCaracciolo/MoneyAPI)


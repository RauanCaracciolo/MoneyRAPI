const BASE_URL = "http://localhost:8080/MoneyRAPI/transactions";

// Estado global da página atual
let currentPage = 0;
const pageSize = 10;

// Cadastro
document.getElementById("postForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const description = document.getElementById("postDescription").value;
  const value = parseFloat(document.getElementById("postValue").value);
  const type = document.getElementById("postType").value;
  const category = document.getElementById("postCategory").value;

  const date = new Date();
  const formattedDate = `${String(date.getDate()).padStart(2, "0")}-${String(date.getMonth() + 1).padStart(2, "0")}-${date.getFullYear()}`;

  const data = {
    value: value,
    desc: description,
    type: type,
    cat: category,
    time: formattedDate
  };

  const response = await fetch(BASE_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data)
  });

  if (response.ok) {
    alert("Transação cadastrada!");
    getAllTransactions();
  } else {
    alert("Erro ao cadastrar transação");
  }
});

// Visualizar tudo com paginação
async function getAllTransactions() {
  const res = await fetch(`${BASE_URL}/paginated?page=${currentPage}`);
  const data = await res.json();
  renderTable(data);
}

// Filtros
async function filterTransactions() {
  const category = document.getElementById("filterCategory").value.trim();
  const type = document.getElementById("filterType").value;

  let url = BASE_URL;

  if (category && type) {
    url += `/categoryandtype/${category}+${type}`;
  } else if (category) {
    url += `/category/${category}`;
  } else if (type) {
    url += `/type/${type}`;
  } else {
    getAllTransactions();
    return;
  }

  const res = await fetch(url);
  const data = await res.json();
  renderTable(data);
}

// Renderiza a tabela
function renderTable(transactions) {
  const tbody = document.getElementById("transactionsTableBody");
  tbody.innerHTML = "";

  transactions.forEach((t) => {
    const tr = document.createElement("tr");
    tr.classList.add("hover:bg-gray-100", "cursor-pointer");
    tr.addEventListener("click", () => {
      window.location.href = `edit.html?id=${t.id}`;
    });
    tr.innerHTML = `
      <td class="p-2">${t.id}</td>
      <td class="p-2">${t.desc}</td>
      <td class="p-2">${t.value.toFixed(2)}</td>
      <td class="p-2">${t.type}</td>
      <td class="p-2">${t.cat}</td>
      <td class="p-2">${t.time}</td>
    `;
    tbody.appendChild(tr);
  });
}

// Relatório
async function getRelatory() {
  const res = await fetch(`${BASE_URL}/relatory`);
  const data = await res.json();

  const container = document.getElementById("relatoryOutput");
  container.innerHTML = "";

  const createCard = (title, value, color, tipo) => `
    <div onclick="window.location.href='relatory.html?tipo=${tipo}'"
      class="cursor-pointer bg-${color}-100 border-l-4 border-${color}-600 text-${color}-800 p-4 rounded shadow hover:bg-${color}-200 transition">
      <h3 class="text-lg font-semibold">${title}</h3>
      <p class="text-2xl font-bold">R$ ${value.toFixed(2)}</p>
    </div>
  `;

  container.innerHTML += createCard("Total de Entradas", data.totalIncome || 0, "green", "income");
  container.innerHTML += createCard("Total de Saídas", data.totalExpense || 0, "red", "expense");
  container.innerHTML += createCard("Saldo Final", data.totalIncome - data.totalExpense || 0, "blue", "none");
}

// Paginação
document.getElementById("prevPage").addEventListener("click", () => {
  if (currentPage > 0) {
    currentPage--;
    getAllTransactions();
  }
});

document.getElementById("nextPage").addEventListener("click", () => {
  currentPage++;
  getAllTransactions();
});

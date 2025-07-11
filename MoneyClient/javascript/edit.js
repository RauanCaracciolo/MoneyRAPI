const BASE_URL = "http://localhost:8080/MoneyRAPI/transactions";

// Pega o ID da URL
const params = new URLSearchParams(window.location.search);
const id = params.get("id");
console.log(`${BASE_URL}/${id}`)
if (id) {
  fetch(`${BASE_URL}/${id}`)
    .then(res => res.json())
    .then(data => {
      document.getElementById("editDescription").value = data.desc;
      document.getElementById("editValue").value = data.value;
      document.getElementById("editCategory").value = data.cat;
      document.getElementById("editType").value = data.type;
      const [year, month, day] = data.time.split("-");
      document.getElementById("editDate").value = `${day}-${month}-${year}`;
    })
    .catch(() => alert("Erro ao carregar transação"));
}

document.getElementById("editForm").addEventListener("submit", async (e) => {
  e.preventDefault();

  const updatedTransaction = {
    desc: document.getElementById("editDescription").value,
    value: parseFloat(document.getElementById("editValue").value),
    cat: document.getElementById("editCategory").value,
    type: document.getElementById("editType").value,
    time: document.getElementById("editDate").value  // deve estar em dd-MM-yyyy
  };

  const response = await fetch(`${BASE_URL}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(updatedTransaction)
  });

  if (response.ok) {
    alert("Transação atualizada!");
    window.location.href = "index.html";
  } else {
    alert("Erro ao atualizar transação.");
  }
});
// DELETE
document.getElementById("deleteButton").addEventListener("click", async () => {
  if (!confirm("Tem certeza que deseja excluir esta transação?")) return;

  try {
    const res = await fetch(`${BASE_URL}/${id}`, {
      method: "DELETE",
    });

    if (!res.ok) throw new Error("Falha ao excluir transação");

    alert("Transação excluída com sucesso!");
    window.location.href = "index.html";
  } catch (error) {
    alert("Erro ao excluir: " + error.message);
  }
});


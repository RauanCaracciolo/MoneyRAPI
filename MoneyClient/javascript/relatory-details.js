document.addEventListener("DOMContentLoaded", async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const tipo = urlParams.get("tipo"); // "income" ou "expense"
  const titulo = tipo === "income" ? "Entradas Detalhadas" : "Saídas Detalhadas";
  document.getElementById("titulo").textContent = titulo;

  try {
    const res = await fetch("http://localhost:8080/MoneyRAPI/transactions/relatory");
    if (!res.ok) throw new Error(`Erro na requisição: ${res.status}`);

    const data = await res.json();

    // Seleciona as categorias e valores conforme o tipo
    const categories = tipo === "income" ? data.categoryIncome : data.categoryExpense;

    // Prepara arrays para gráfico
    const labels = Object.keys(categories);
    const valores = Object.values(categories);

    // Renderiza gráfico pizza
    const ctx = document.getElementById('graficoPizza').getContext('2d');
    new Chart(ctx, {
      type: 'pie',
      data: {
        labels: labels,
        datasets: [{
          label: 'Total por Categoria',
          data: valores,
          backgroundColor: [
            '#60A5FA', '#34D399', '#FBBF24', '#F87171', '#A78BFA',
            '#F472B6', '#4ADE80', '#FCD34D', '#93C5FD'
          ],
          borderColor: '#fff',
          borderWidth: 2,
        }]
      },
      options: {
        responsive: true,
        plugins: {
          legend: {
            position: 'bottom',
            labels: { font: { size: 14 } }
          },
          tooltip: {
            callbacks: {
              label: ctx => `${ctx.label}: R$ ${ctx.parsed.toFixed(2)}`
            }
          }
        }
      }
    });

    // Renderiza detalhes numéricos abaixo do gráfico
    const detalhesDiv = document.getElementById("detalhes");
    detalhesDiv.innerHTML = "";

    labels.forEach((label, i) => {
      const valor = valores[i];
      const card = document.createElement("div");
      card.className = "bg-gray-50 border border-gray-300 rounded p-4 shadow-sm";

      card.innerHTML = `
        <h3 class="font-semibold mb-1">${label}</h3>
        <p class="text-lg font-bold text-gray-700">R$ ${valor.toFixed(2)}</p>
      `;

      detalhesDiv.appendChild(card);
    });

  } catch (error) {
    alert("Erro ao carregar o relatório detalhado: " + error.message);
  }
});

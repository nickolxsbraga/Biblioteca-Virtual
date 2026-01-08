document.addEventListener("DOMContentLoaded", () => {
    carregarLivros();
});

function carregarLivros() {
    fetch("/api/livros")
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao buscar livros");
            }
            return response.json();
        })
        .then(livros => {
            const tabela = document.getElementById("tabelaLivros");
            tabela.innerHTML = "";

            livros.forEach(livro => {
                const linha = document.createElement("tr");

                linha.innerHTML = `
                    <td>${livro.id}</td>
                    <td>${livro.titulo}</td>
                    <td>${livro.categoria}</td>
                    <td>${livro.ano_publicacao}</td>
                    <td>${livro.disponivel ? "Disponível" : "Reservado"}</td>
                `;

                tabela.appendChild(linha);
            });
        })
        .catch(error => {
            console.error(error);
            alert("Erro ao carregar catálogo");
        });
}

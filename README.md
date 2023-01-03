<div align="center">
  <img src="https://uoledtech.com.br/hubfs/Imported_Blog_Media/20943526-scaled-1.jpg" width="50%">
  <h1 style="border-bottom:none">Crud de Cliente usando Model Mapper</h1>
  <p>Author: José Ricardo</p>
  
  
  <a href="https://www.linkedin.com/in/ze-ricardo/">
     <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white">
  </a>
    <a href="https://www.buymeacoffee.com/codeandmusic" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="28" width="174"></a>
  
  <br>
  <br>
  <p>Usar o model maper para atualizar o cliente da base.

  o que o mapper faz é pegar todas as informaçoes de cliente nome, email e cpf e adicioana o cliente base.
  E caso não seja enviado nenhum dos atributos nome, email e cpf.
  O map vai adicionar nulo.

  Entao criei um bean do modelmapper na classe principal para qando usar o model mapper ele não considere os valores nulos.
  E desta forma toda vez que a aplicação for executada a configuração na classe principal seja aplicada.
  Então os atributos não informados não serão atualizados no cliente da base de dados.</p>
  <br>
  <div align="justify">
  <h3>Tecnologias:</h3>
  
   + MySQL;
   + JPA;
   + Spring Boot;
   + Java 11;
   + Model Mapper;
   + Lombok
   + Thunder Client;
   + Rodar Aplicação comando mvn spring-boot:run

  </div>
</div>

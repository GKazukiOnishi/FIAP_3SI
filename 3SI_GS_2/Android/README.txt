Professor, como baseamos o aplicativo na solução do grupo, a tela acabou apresentando
elementos extras para possibilitar o uso dela como protótipo da solução, então existem
vários botões e links que não estão associados a nenhuma ação, então a ideia desse
readme é explicar quais botões funcionam efetivamente:

Na home do aplicativo, temos vários cards que representam uma espécie de menu da aplicação, dentre
eles o card de "Grupo Familiar" é o único que funciona, levando a uma tela de listagem dos integrantes
da família do usuário e suas informações médicas. Ela está usando RecyclerView e também está
associada a uma tabela do banco de dados local, mas os botõos de edição e adição são apenas decorativos.

Para voltar a home, pode-se usar o menu da AppBar, no canto superior direito, clicando em "Home".
Nela também temos uma seção de "Último Atendimento", em que temos um Card referente às informações
do último atendimento e um botão para acessar seus dados, esse botão está implementado e leva para
a tela de detalhe do atendimento, em que temos informações Mockadas.

No menu do canto superior direito da aplicação, na AppBar, temos alguns outros links, e dentre eles
o que implementamos é o de "Lembretes", ele leva para a tela de "Lembretes Preventivos", em que
temos uma lista usando RecyclerView para exibir todos os lembretes cadastrados para o usuário.
Nela também é possível Adicionar e Editar um lembrete, que leva a uma tela de formulário do lembrete,
estando associada a uma tabela no banco de dados local.

Para dar um contexto da nossa solução, basicamente ela se baseia em incentivar a prevenção e o
cuidado médico, também facilitando o contato com o estabelecimento, de forma que o aplicativo
traz diversas informações médicas de forma centralizada, com telas para aproximar o médico de
seu paciente e facilitar o contato se necessário. Os lembretes preventivos surgiram com a ideia
de que tendo todas essas informações, seria uma boa forma de incentivar a prevenção implementando
uma feature de cadastro de lembretes pelo paciente e pelos médicos, de forma que seria possível
que o médico cadastrasse o retorno do paciente ou o próprio paciente cadastrasse suas consultas
rotineiras, possibilitando na sua versão completa um ótimo pós-atendimento, qualidade que tem
faltado nos serviços da área.
E utilizando a ideia de Grupo Familiar, seria possível também acessar as informações de seus
familiares, dado que nem sempre temos em mão facilmente, a exemplo de nossos avós que tendem
a esquecer das suas consultas, disponibilizando para uma maior privacidade configurações de
compartilhamento.
# cqrs-eventStore

this is sample product order application using sqrs desing pattern and event sourcing

Prerequisite 
java 11+
spring boot knowledge 
Axon server (you can download it from <a href="https://developer.axoniq.io/download" >here</a>)

<b>CQRS architecture :</b>
CQRS main porpous to segregate writes opertaions and read operations 
each opertion has intent 
<br/>write operations are commands
<br/>read operations are queries


![cqrs arch](https://github.com/mahmoud-fouad/cqrs-eventStore/assets/20505530/a2980ed4-52e4-4b76-a867-80efbed9b3fc)



Cases
user want to add products 

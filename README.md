I'll updating this repo with almost all the information, this is my twitter, please follow me to updates questions or suggestions.
[@acardenasnet](https://twitter.com/acardenasnet)

To start you need execute the below commands:

```shell script
docker run -d --name=dev-consul -e CONSUL_BIND_INTERFACE=eth0 -p 8500:8500 consul
docker run -d -e CONSUL_BIND_INTERFACE=eth0 consul agent -dev -join=172.17.0.2
docker run -d -e CONSUL_BIND_INTERFACE=eth0 consul agent -dev -join=172.17.0.2
```

The first one run consul, the second one run other consult agent and register with the first one, and it's the same to the third command.

Due this example will need postgres, you can also start a docker image to test it.

```shell script
docker run -d --rm -p 5432:5432 -e POSTGRES_PASSWORD=orders -e POSTGRES_USER=orders -e POSTGRES_DB=orders postgres:alpine
```

After this you can start this service executing:

````shell script
mvn sprong-boot:run
````


Into the controller can see the following snippet:

```java
  @Autowired
  private DiscoveryClient discoveryClient;
  
  public Optional<URI> serviceUrl() {
    return discoveryClient.getInstances("coupon-service")
        .stream()
        .map(serviceInstance -> serviceInstance.getUri())
        .findFirst();
  }
```

The method above returns all the instances registered in Consul, healthy and unhealthy, in the branch `load_balanced` I will explain how avoid to bring all the instances and only retrieve the healthies




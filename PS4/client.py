import zeep

# Adres WSDL Twojego serwisu działającego na WildFly
wsdl_url = "http://localhost:8080/WebServicesWildfly/HelloWorldImpl?wsdl"

try:
    # Inicjalizacja klienta
    client = zeep.Client(wsdl=wsdl_url)

    # 1. Wywołanie metody getHelloWorldAsString (Zadanie 2)
    # Jeśli w Ćwiczeniu 5 zmieniłeś operationName, użyj nowej nazwy!

    # 2. Wywołanie metody getProducts (Zadanie 5 / Ćwiczenie 4)
    products = client.service.getProducts()
    print("\nLista produktów z serwisu Java:")
    for p in products:
        print(f"- {p.nazwa} ({p.opis}): {p.cena} PLN")

except Exception as e:
    print(f"Błąd: Upewnij się, że WildFly jest włączony! {e}")
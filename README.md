Read this document in turkish language :point_left:

## Nedir ? 

Spring Boot frameworkü kullanılarak geliştirilmiş bir web servisidir. [Dictionary](https://raw.githubusercontent.com/firatkaya1/dictionary) database'sini daha rahat kullanabilmek için oluşturulmuştur.    

## Nasıl Yükleyebilirim ? 

Projeyi bilgisayarınıza kopyalayın. 

```git
git clone https://github.com/firatkaya1/dictionary-api.git
```
Ardından projeyi clonlamış olduğunuz path'in içine terminal ekranından girin. 

```
cd dictionary-api
```
Java projesini .jar dosyası haline getirin.

```
mvn clean package
```

Sonra projeyi docker aracılığıyla build edin. 

```
docker build -f Dockerfile -t dictionary-api .
```

Son olarak, docker'i çalıştırın. 

```
docker run -p 8085:8085 dictionary-api
```
Tarayıcınızı açın ve **localhost:8085** adresine istek atın. İşte bu kadar, projeyi başarılıyla bilgisayarınıza kurdunuz. :punch: 

## Nasıl Uygularım ? 

Bu adımda, başarılı bir şekilde çalıştırdığımız web servisin end-pointlerinin neler olduğunu, nasıl kullanıldığını ve örnek sonuçlarını inceleyeceğiz. Bu web servisi swagger dökümantasyonu bulunmaktadır. Eğer tüm end-pointleri görmek istiyorsanız, **localhost:8085/swagger-ui/index.html** adresine istek atınız. 

Basit bir şekilde bu web servis, İngilizce,Türkçe kelimelere, Kategori ve Tip alanlarında arama,ekleme,çıkarma,güncelleme ve silme işlemlerini yapmasını sağlamak için oluşturulmuştur. Database'nin kendisine [bu adresten](https://raw.githubusercontent.com/firatkaya1/dictionary) ulaşabilirsiniz. 

Toplamda 4 adet temel end-point bulunmaktadır. Bunlar english/  turkish/  category/  type/  ve translate/  dir. 

| Endpoint | HTTP Method | Açıklama |
| ------------- | ------------- |------------- |
| english/{id}  | GET  | Belirtilen ID numarasına sahip ingilizce kelimeyi getirir. |
| english/ | POST | Yeni bir ingilizce kelime eklemek için kullanılır. (1) |
| english/ | PUT | Veritabanında kayıtlı bir ingilizce kelimeyi güncellemek için kullanılır.  |
| english/{id}  | DELETE | Veritabanında kayıtlı bir ingilizce kelimeyi silmek için kullanılır. |

| Endpoint | HTTP Method | Açıklama |
| ------------- | ------------- |------------- |
| turkish/{id}  | GET  | Belirtilen ID numarasına sahip türkçe kelimeyi getirir. |
| turkish/ | POST | Yeni bir türkçe kelime eklemek için kullanılır. (1) |
| turkish/ | PUT | Veritabanında kayıtlı bir türkçe kelimeyi güncellemek için kullanılır.  |
| turkish/{id}  | DELETE | Veritabanında kayıtlı bir türkçe kelimeyi silmek için kullanılır. |

| Endpoint | HTTP Method | Açıklama |
| ------------- | ------------- |------------- |
| category/{id}  | GET  | Belirtilen ID numarasına sahip kategoriyi getirir. |
| category/ | POST | Yeni bir kategori eklemek için kullanılır. (1) |
| category/ | PUT | Veritabanında kayıtlı bir kategoriyi güncellemek için kullanılır.  |
| category/{id}  | DELETE | Veritabanında kayıtlı bir kategori silmek için kullanılır. |

| Endpoint | HTTP Method | Açıklama |
| ------------- | ------------- |------------- |
| type/{id}  | GET  | Belirtilen ID numarasına sahip kelime tipini getirir. |
| type/ | POST | Yeni bir kelime tipi eklemek için kullanılır. (1) |
| type/ | PUT | Veritabanında kayıtlı bir kelime tipini güncellemek için kullanılır.  |
| type/{id}  | DELETE | Veritabanında kayıtlı bir kelime tipini silmek için kullanılır. |







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

Toplamda 5 adet temel end-point bulunmaktadır. Bunlar english/  turkish/  category/  type/  ve translate/  dir. 

| Endpoint | HTTP Method | Açıklama |
| ------------- | ------------- |------------- |
| translate/id/{id}  | GET  | Belirtilen ID numarasına sahip eşleştirilmiş kelimeleri getirir. |
| translate/{word} | GET | İngilizce kelimenin türkçe anlamlarını getirir. |
| translate/ | GET | İngilizce kelimenin türkçe anlamlarını sayfalaştırılabilir bir formatta getirir. |
| english/{id}  | GET  | Belirtilen ID numarasına sahip ingilizce kelimeyi getirir. |
| english/ | POST | Yeni bir ingilizce kelime eklemek için kullanılır. |
| english/ | PUT | Veritabanında kayıtlı bir ingilizce kelimeyi güncellemek için kullanılır.  |
| english/{id}  | DELETE | Veritabanında kayıtlı bir ingilizce kelimeyi silmek için kullanılır. |
| english/ | GET | Tüm ingilizce kelimeleri sayfalaştırılabilir bir formatta getirir. |
| turkish/{id}  | GET  | Belirtilen ID numarasına sahip türkçe kelimeyi getirir. |
| turkish/ | POST | Yeni bir türkçe kelime eklemek için kullanılır. |
| turkish/ | PUT | Veritabanında kayıtlı bir türkçe kelimeyi güncellemek için kullanılır.  |
| turkish/{id}  | DELETE | Veritabanında kayıtlı bir türkçe kelimeyi silmek için kullanılır. |
| turkish/ | GET | Tüm ingilizce kelimeleri sayfalaştırılabilir bir formatta getirir. |
| category/{id}  | GET  | Belirtilen ID numarasına sahip kategoriyi getirir. |
| category/ | POST | Yeni bir kategori eklemek için kullanılır. |
| category/ | PUT | Veritabanında kayıtlı bir kategoriyi güncellemek için kullanılır.  |
| category/{id}  | DELETE | Veritabanında kayıtlı bir kategori silmek için kullanılır. |
| type/{id}  | GET  | Belirtilen ID numarasına sahip kelime tipini getirir. |
| type/ | POST | Yeni bir kelime tipi eklemek için kullanılır. |
| type/ | PUT | Veritabanında kayıtlı bir kelime tipini güncellemek için kullanılır.  |
| type/{id}  | DELETE | Veritabanında kayıtlı bir kelime tipini silmek için kullanılır. |


## Örnek Kullanımları

### 1- Kelimenin Türkçe anlamlarını elde etme

İstediğiniz bir ingilizce kelimenin, türkçe anlamlarını sayfalaştırılabilir bir formatta JSON tipinde getirmek istiyorsanız aşağıdaki şekilde istek 
atarak elde edebilirsiniz. Örnek olarak **hello** kelimesi kullanılmıştır.  
Burada gerekli olan tek şey aramak istediğiniz kelimedir. Diğer değerler istenildiği takdirde yazılır. Parantez içindekiler default değerleri temsil eder.  
**page** = Bulunduğu sayfa sayısını(1),     
**size** = Bir sayfadaki element sayısını(10),    
**sort** = Kelimelerin sıralama tipini(id)  
**order** = Azalan yada Artan değerini(asc),  
**word** = Aratılmak istenen kelimeyi temsil eder.

```
curl -X GET "http://localhost:8085/translate?order=asc&page=1&size=10&sort=id&word=word" -H "accept: */*"
```
Örnek çıktısı : 

```json
{
  "content": [
    {
      "id": 635276,
      "word_en": "hello",
      "word_tr": "merhaba",
      "category": "Common Usage",
      "type": "interjection"
    },
    {
      "id": 635277,
      "word_en": "hello",
      "word_tr": "merhaba",
      "category": "General",
      "type": "interjection"
    },
    {
      "id": 635278,
      "word_en": "hello",
      "word_tr": "selam",
      "category": "General",
      "type": "interjection"
    },
    {
      "id": 635279,
      "word_en": "hello",
      "word_tr": "alo",
      "category": "General",
      "type": "interjection"
    },
    {
      "id": 635280,
      "word_en": "hello",
      "word_tr": "merhabalar",
      "category": "Speaking",
      "type": "noun"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "pageNumber": 0,
    "pageSize": 10,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 5,
  "last": true,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "size": 10,
  "number": 0,
  "numberOfElements": 5,
  "first": true,
  "empty": false
}
```
### 2- Kelimenin Türkçe anlamlarını elde etme
Burada ise, yukarıdaki işlemin aynısı tekrarlanmaktadır. Fakat burada elde edilen çıktı yukarıdakinden daha farklıdır. Çıktı sadece bir liste yapısı içerir. Sayfalaştırılmış bir format sunmaz. Bu yöntemin kullanılması *tavsiye edilmez*. Talep ettiğiniz kelimenin yüzlerce anlamı var ise, bekleme süreniz daha fazla olacaktır. 
```
curl -X GET "http://localhost:8085/translate/hello" -H "accept: */*"
```
Örnek çıktısı : 

```json
[
  {
    "id": 635276,
    "word_en": "hello",
    "word_tr": "merhaba",
    "category": "Common Usage",
    "type": "interjection"
  },
  {
    "id": 635277,
    "word_en": "hello",
    "word_tr": "merhaba",
    "category": "General",
    "type": "interjection"
  },
  {
    "id": 635278,
    "word_en": "hello",
    "word_tr": "selam",
    "category": "General",
    "type": "interjection"
  },
  {
    "id": 635279,
    "word_en": "hello",
    "word_tr": "alo",
    "category": "General",
    "type": "interjection"
  },
  {
    "id": 635280,
    "word_en": "hello",
    "word_tr": "merhabalar",
    "category": "Speaking",
    "type": "noun"
  }
]
```

### 3- ID değerlerine göre getirme 

Bu başlık altında, bir ID değerine göre ingilizce, türkçe kelime, kategori ve type getirilmesi gösterilmiştir. 

Sadece ingilizce kelimeyi getirmek için;  
```
curl -X GET "http://localhost:8085/english/125365" -H "accept: */*"
```
 Örnek çıktısı  
```
{
  "id": 125365,
  "en_word": "outports"
}
```
Sadece türkçe kelimeyi getirmek için;
```
curl -X GET "http://localhost:8085/turkish/56324" -H "accept: */*"
```
 Örnek çıktısı  
```
{
  "id": 56324,
  "word": "astronot gibi"
}
```
Sadece kategori getirmek için; 
```
curl -X GET "http://localhost:8085/category/35" -H "accept: */*"
```
 Örnek çıktısı  
```
{
  "id": 35,
  "name": "Music"
}
```

Sadece type getirmek için;  
```
curl -X GET "http://localhost:8085/type/3" -H "accept: */*"
```
 Örnek çıktısı  
```
{
  "id": 3,
  "name": "adverb"
}
```










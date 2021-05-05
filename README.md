# JavaCamp-GameCenterProject
## Yazılım Geliştirici Yetiştirme Kampı (JAVA &amp; REACT) - Game Store Project
### Bu çalışma saygıdeğer hocamız Engin Demiroğ'un Yazılım Geliştirici Yetiştirme Kampı (Java & React) eğitimi sırasında verilen ödev için hazırlanmıştır.

* Veritabanı simülasyonu hazırlandı. Uygulama çalışırken veriler bir veritabanı mantığına uygun olarak bellekte tutuluyor, uygulama sonunda sıfırlanıyor.
* Bazı soyutlamalar eksik kaldı, düzeltilecek
* Kerem Varış hocamızın Linkedin'deki <a href="https://www.linkedin.com/pulse/yaz%C4%B1l%C4%B1mc%C4%B1n%C4%B1n-gizli-kabusu-constructor-injection-cehennemi-kerem-varis"/>Yazılımcının Gizli Kabusu Constructor Injection Cehennemi Nedir?</a> başlıklı yazısından esinlenerek bir ServiceFactory çalışması yapılmaya çalışıldı. Ancak Java'daki karşılığı konusunda bilgi eksiklikleri olduğu için eksik, hatta yanlış olabilir. (Özellikle injection sınıflarının örneğinin uygulama başlarken oluşturulması ciddi bir sorun. İstekte bulunulduğu anda sınıf örneğinin oluşturulup, işi bitince bellekten kaldırılacak bir sistem kurulmalı. Üzerinde çalışılıyor).
* Sistem birden fazla oyunun satışa sunulması ve bir siparişte birden fazla oyun satın alınması olasılıkları gözönünde tutularak hazırlandı.
* Zaman kısıtlılığı ndeniyle Order ve OrderDetail iş sınıfları birleştirildi.
* Uygulamada 3 çeşit kullanıcı doğrulaması mevcut. (Doğrudan MERNİS üzerinden kontrol, sadece TC Kimlik Numarası algoritmasına ilişkin kontrol ve sadece true sonucunu döndüren test kontrolü). İsteğe göre bu üç doğrulamadan biri kullanılabilir.
* Farklı tipte kullanıcı kaydı olanağı sunuldu ve kimlik doğrulamasına uygun kullanıcı tipi ayarlanabilmesi için MernisValidatable interface'i oluşturuldu. Gamer kullanıcı sınıfı, aynı zamanda bu interface'in bir implementasyonu.
* User - Gamer sınıf tanımlamaları ile inheritance kavramına örnek oluşturulmaya çalışıldı. Ancak bazı işlemler yeterince uygun hale getirillemedi. Daha doğru ve sağlıklı kullanım için Code refactoring gerekecektir.

<img src="https://github.com/barisertugrul/JavaCamp-GameCenterProject/blob/master/images/java_game_center_output.png"/>


<a href="https://github.com/barisertugrul/JavaCamp-GameCenterProject">
  <img align="center" src="https://github-readme-stats.vercel.app/api/pin/?username=barisertugrul&show_owner=true&custom_title=Odevler&theme=vision-friendly-dark&repo=JavaCamp-GameCenterProject" />
</a>

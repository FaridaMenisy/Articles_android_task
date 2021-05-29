# MVVM_KOTLIN_ANDROID_DAGGER_JETPACK


It's a sample project that created with MVVM architecture using jetcpack components e.g(ViewModel, Room, LiveData)

**Brief** : App consists of three screens (master/detail)

       1-Splash Screen
       2-Main Screen(displaying list of articles)
       3-Details Screen(displayed upon clicking on each list item)
       
**Steps** :
  
    1-When App runs, service that provides articles data is called and you see loading till data returns.
    2-If an error occured, data will be fetched from database.
    3-If No data found in dbase, you will see an error message where you can tap to refresh again.
    4-When service returns successfully from network, database is updated
      
<h2>Technologies and Frameworks</h2>        

**Kotlin**

**JetPack Components** [ViewModel,LiveData,Room]

**Dagger**

**MVVM**

**Clean code Archtiecture**

**Unit testing** : Local unit testing using Mockito and Junit was used, as well as Database testing 

          Destination directoty for unit testing app\src\test

          Destination directory for database testing: app\src\AndoidTest\. as our test class requires context from the application.
          
          
**Steps to run test cases**:

![image](https://user-images.githubusercontent.com/26609049/120055685-fa4cbf00-c037-11eb-9c92-5557403ab272.png)
![WhatsApp Image 2021-05-29 at 4 29 42 AM (1)](https://user-images.githubusercontent.com/26609049/120055492-c91fbf00-c036-11eb-9a0e-5635c53fa066.jpeg)
![WhatsApp Image 2021-05-29 at 4 29 42 AM (2)](https://user-images.githubusercontent.com/26609049/120055497-cc1aaf80-c036-11eb-82cf-cff9d9c7007e.jpeg)




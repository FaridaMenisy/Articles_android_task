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

**Object oriented Programming**

**Retrofit**

**JetPack Components** [ViewModel,LiveData,Room]

**Dagger**

**MVVM**

**Clean code Archtiecture**

**Unit testing** : Local unit testing using Mockito and Junit was used, as well as Database testing 

          Destination directoty for unit testing app\src\test

          Destination directory for database testing: app\src\AndoidTest\. as our test class requires context from the application.
          
          
**Run test cases**          


<img width="374" alt="Screen Shot 2021-05-29 at 4 57 48 AM" src="https://user-images.githubusercontent.com/26609049/120056183-e191d880-c03a-11eb-9419-1f7095b70e80.png">

If you choose run with coverage, you get to see the coverage percentage of each package.
<img width="761" alt="Screen Shot 2021-05-29 at 5 00 51 AM" src="https://user-images.githubusercontent.com/26609049/120056184-e2c30580-c03a-11eb-9341-6cd7e999f7bb.png">



<h2>SnapShots</h2>

![image](https://user-images.githubusercontent.com/26609049/120055685-fa4cbf00-c037-11eb-9c92-5557403ab272.png)
![WhatsApp Image 2021-05-29 at 4 29 42 AM (1)](https://user-images.githubusercontent.com/26609049/120055492-c91fbf00-c036-11eb-9a0e-5635c53fa066.jpeg)
![WhatsApp Image 2021-05-29 at 4 29 42 AM (2)](https://user-images.githubusercontent.com/26609049/120055497-cc1aaf80-c036-11eb-82cf-cff9d9c7007e.jpeg)




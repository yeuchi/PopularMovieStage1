# PopularMovieStage1
Android class first assignment

### Abstract
This project utilizes the following skils from Lesson 1 - 4.
* Picasso to load images http://square.github.io/picasso/
* Movie db service https://www.themoviedb.org/?_dc=1503193705
* Recyclerview
* GridLayout
* NetworkUtils
* Intent
* Progress bar, menu, json

By default (without api key) this code is expected to produced a display of progress, then network error.
![networkerror](https://user-images.githubusercontent.com/1282659/29491595-3e8f8528-8525-11e7-95f9-4dd5986bf8ea.png)
![progress](https://user-images.githubusercontent.com/1282659/29491593-336a1d34-8525-11e7-9070-9b86e7fdbe31.png)

With a valid api key
1. Upon launch, present the user with an grid arrangement of movie posters
2. Allow your user to change sort order via a setting (most popular, or by top rated)

### Popular
![popular2](https://user-images.githubusercontent.com/1282659/29491603-745c4b32-8525-11e7-8ad9-2505fe8b2ce9.png)
![popular](https://user-images.githubusercontent.com/1282659/29491604-7693a3b4-8525-11e7-876d-3cb94d0bba18.png)

### Top Rated
![toprated2](https://user-images.githubusercontent.com/1282659/29491599-5f1ce952-8525-11e7-82ad-7e01383cd5b1.png)
![toprated](https://user-images.githubusercontent.com/1282659/29491600-6340f186-8525-11e7-941b-257addf2e7e6.png)

3. Allow the user to tap on a movie poster and transition to a details screen with additional information such as:
   a. original title
   b. movie poster image thumbnail
   c. A plot synopsis (called overview in the api)
   d. user rating (called vote_average in the api)
   e. release date
![detail2](https://user-images.githubusercontent.com/1282659/29491596-4d9b1e88-8525-11e7-92ce-d6b881489901.png)
![detail](https://user-images.githubusercontent.com/1282659/29491582-0ac14a06-8525-11e7-83d5-0f0177511623.png)

### Summary
1. Developed and tested on Google Android Pixel, Simulation.
2. Basic functionality with no thrills nor details for different form factor.

### Appendix
1. Additional insert sort via bisection method is available with BigO logN performance. 
2. JSONhelper is consolidated and maybe useful for outside project.

### Nice to add next
1. Different layouts for vertical / horizontal.
2. Load additional pages from service (prior + after)
3. More error verbose from different part of the app.
4. Grid size should dynamically change to fit different form factor.

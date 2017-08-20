# PopularMovieStage1
Android class first assignment

# Abstract
This project requires the following skils from Lesson 1 - 4.
* Picasso to load images http://square.github.io/picasso/
* Movie db service https://www.themoviedb.org/?_dc=1503193705
* Recyclerview
* GridLayout
* NetworkUtils
* Intent
* Progress bar, menu, json

# By default (without api key) this code is expected to produced a display of progress, then network error.
![alt text](http://ctyeung.com/mobile/udacity/networkError.png)
![alt text](http://ctyeung.com/mobile/udacity/progress.png)

# With a valid api key
1. Upon launch, present the user with an grid arrangement of movie posters
2. Allow your user to change sort order via a setting (most popular, or by top rated)
![alt text](http://ctyeung.com/mobile/udacity/popular.png)
![alt text](http://ctyeung.com/mobile/udacity/popular2.png)

![alt text](http://ctyeung.com/mobile/udacity/topRated.png)
![alt text](http://ctyeung.com/mobile/udacity/topRated2.png)

3. Allow the user to tap on a movie poster and transition to a details screen with additional information such as:
   a. original title
   b. movie poster image thumbnail
   c. A plot synopsis (called overview in the api)
   d. user rating (called vote_average in the api)
   e. release date
![alt text](http://ctyeung.com/mobile/udacity/detail.png)
![alt text](http://ctyeung.com/mobile/udacity/detail2.png)

# Summary
1. Developed and tested on Pixel Simulation android.
2. Basic functionality with no thrills nor details for different form factor.

# Appendix
1. Additional insert sort via bisection method is available with BigO logN performance. 
2. JSONhelper is consolidated and maybe useful for outside project.

# Nice to add next
1. Different layouts for vertical / horizontal.
2. Load additional pages from service (prior + after)
3. More error verbose from different part of the app.
4. Grid size should dynamically change to fit different form factor.

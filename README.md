# mercari-android-test
For Technical interview 

![screenshot](https://preview.ibb.co/fst4d5/Screen_Shot_2017_05_05_at_2_56_26_PM.png)

## Technical Details
- I created a `Network module`, this module will be responsible for all network related tasks including parsing `json`. The future implementation would require more dependencies within the `Network module` such as threading, etc depending on the framework of choice.
- The overall architecture follows the `MVC` pattern. This pattern is common in most UI driven apps. Here any object is either a Modal (data), View (ui), or Controller (handles interaction between modal and view).
- The main libraries I used were `ButterKnife` for view injection, `Dagger2` for dependency injection.
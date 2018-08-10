# ClockView

<a href='https://bintray.com/nickunuchek/maven/clockview?source=watch' alt='Get automatic notifications about new "clockview" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>

<a href='https://bintray.com/nickunuchek/maven/clockview/_latestVersion'><img src='https://api.bintray.com/packages/nickunuchek/maven/clockview/images/download.svg'></a>


<img src='https://github.com/Kolyall/ClockView/blob/master/github/Screenshot_20180809_173829.png' width="216" height="384">

```
dependencies {
      compile 'com.github.kolyall:library_view_clock:{latestVersion}'
}
```
Usage:
```
 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clockView = findViewById<ClockView>(R.id.clockImageView)
        clockView.setClockBgColor(ContextCompat.getColor(this, R.color.colorPrimary))
        setupClockView(clockView)
    }

    private fun setupClockView(clockView: ClockView) {
        val startTime = Date()
        val calendar = Calendar.getInstance()
        calendar.time = startTime
        clockView.setHour(calendar.get(Calendar.HOUR_OF_DAY))
        clockView.setMinute(calendar.get(Calendar.MINUTE))

        clockView.setClockColor(ContextCompat.getColor(this, R.color.colorAccent))
    }

}

```
main_activity.xml :
```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.library.clockview.ClockView
        android:id="@+id/clockImageView"
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:background="?attr/selectableItemBackgroundBorderless"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

</android.support.constraint.ConstraintLayout>
```

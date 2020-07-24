package com.vjcet.map

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log

import android.widget.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
 import kotlinx.android.synthetic.main.content_splash.*

class MainActivity : AppCompatActivity()   {


    val reached = "You have reached your destination"

    val mw = "Mechanical Workshop"


    val array = listOf("Main Gate","Auditorium","Library","Canteen","Office")

    val maingateAud = listOf("Take 3m Straight","Take Right","Travel 50m", reached)

    val maingateLib = listOf("Take 3m Straight","Take Right","Travel 50m", "Take left from mechanical workshop","Go Up Stair till you reach B block",reached)

    val maingateCan = listOf("Take 3m Straight","Take Right","Travel 50m","Take Right from Mech Tree","Go 20m Down", reached)

    val maingateOff = listOf("Take 3m Straight","Take Right","Travel 50m","Take left from mechanical workshop","Go Up Stair till you reach B block","Go to first floor of C block", reached)

    val audlib = listOf("Go to Mechanical Workshop","Take Right","Go to C Block", reached)

    val audcan = listOf("Go to Mechanical Workshop","Take Left", reached)

    val audoff = listOf("Go to Mechanical Workshop","Take Right","Go to C Block","Go up Stairs", reached)

    val audmag = listOf("Travel through College road till end", reached)

    val libmg = listOf("Travel down to Mechanical Workshop","Take left","Go further", reached)

    val libaud = listOf("Go down to college road","Take left","Go further", reached)

    val libcan = listOf("Go down to college road","Proceed to $mw ","Go down further", reached)

    val liboff = listOf("From B block navigate to C block","Proceed to first floor", reached)

    val canmg = listOf("Go to $mw","Take left", "Proceed further", reached)

    val canaud = listOf("Go to $mw","Take right","Go further", reached)

    val canlib = listOf("Go to $mw","Proceed to B block","Go to first floor", reached)

    val canoff = listOf("Take 3m Straight","Take Right","Travel 50m","Take left from mechanical workshop","Go Up Stair till you reach B block","Go to first floor of C block", reached)

    val offmg = listOf("Reach the ground floor of C block","Travel down to main college road","Take left", reached)

    val offaud = listOf("Reach the ground floor of C block","Travel down hill","Take Right from mechanical workshop","Travel further", reached)

    val offlib = listOf("Exit C block","Go to B block level - 1", reached)

    val offcan = listOf("Reach the ground floor of C block","Travel down hill","Go down hill from mechanical workshop ","Turn Right", reached)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val from = findViewById<Spinner>(R.id.from) as Spinner
        val to = findViewById<Spinner>(R.id.to)  as Spinner
        val listview = findViewById<ListView>(R.id.listview) as ListView

        val arrayAdapterfrom = ArrayAdapter(this, android.R.layout.simple_spinner_item,array)

        val arrayAdapterto = ArrayAdapter(this, android.R.layout.simple_spinner_item,array)

        from.adapter = arrayAdapterfrom

        to.adapter = arrayAdapterto


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, maingateAud)
        listview.adapter = adapter



        proceed.setOnClickListener {
            setListView(from.selectedItem.toString() ,to.selectedItem.toString())
        }

    }


    fun setListView(i: String, j: String){

        if (i!=j){
            if(i == array[0]){
                when(j){
                    array[1] -> setAdapter(maingateAud)
                    array[2] -> setAdapter(maingateLib)
                    array[3] -> setAdapter(maingateCan)
                    array[4] -> setAdapter(maingateOff)
                }
            }

            if(i == array[1]){
                when(j){
                    array[0] -> setAdapter(audmag)
                    array[2] -> setAdapter(audlib)
                    array[3] -> setAdapter(audcan)
                    array[4] -> setAdapter(audoff)

                }
            }

            if(i == array[2]){
                when(j){
                    array[0] -> setAdapter(libmg)
                    array[1] -> setAdapter(libaud)
                    array[3] -> setAdapter(libcan)
                    array[4] -> setAdapter(liboff)

                }
            }

            if(i == array[3]){
                when(j){
                    array[0] -> setAdapter(canmg)
                    array[1] -> setAdapter(canaud)
                    array[2] -> setAdapter(canlib)
                    array[4] -> setAdapter(canoff)

                }
            }

            if(i == array[4]){
                when(j){
                    array[0] -> setAdapter(offmg)
                    array[1] -> setAdapter(offaud)
                    array[2] -> setAdapter(offlib)
                    array[3] -> setAdapter(offcan)

                }
            }
        }
        else {
            toast("Not Applicable")
            vibratePhone()
        }


    }

    fun setAdapter(list: List<String>){
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listview.adapter = adapter
    }


    fun toast (string: String) = Toast.makeText(applicationContext,string, Toast.LENGTH_SHORT).show()


    fun vibratePhone() {
        val vibrator = application?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(200)
        }
    }
}




//  ViewController.swift
//  Happy Images
//  Created by Álvaro Santillan on 10/5/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.

// Notes to my proff.
// Im pritty sure i got the contstraints to work.
// Tested on simulator and iphone 6 plus
// Works in both portrate and landscape.
// Neglected iPhone 4 becous its obsolite but i think it works for it too.
// Credits at the bottom, Cheers

import UIKit
import AVFoundation

class ViewController: UIViewController {
    
    // Required for audio
    var player: AVAudioPlayer?

    @IBOutlet weak var imageView1: UIImageView!
    @IBOutlet weak var imageView2: UIImageView!
    @IBOutlet weak var imageView3: UIImageView!
    @IBOutlet weak var imageView4: UIImageView!
    @IBOutlet weak var imageView5: UIImageView!
    @IBOutlet weak var segControl: UISegmentedControl!
    @IBOutlet weak var segControlBottom: UISegmentedControl!
    @IBOutlet weak var soundSwitch: UISwitch!
    
    
    override func viewDidLoad() {
        // Load some 1 of two meme sets. Use other then those presented in main storyboard.
        let alMeme = ["viewDL1","viewDL1","viewDL1","viewDL1","viewDL1"]
        let appleArray = ["t1","t2","t3","t4","t5"]
        var display = alMeme
        
        // Random number generaion.
        let randomNumber = Int.random(in: 0 ... 1)
        if randomNumber == 1 {
            display = appleArray
        }
        super.viewDidLoad()
        // Update image views
        imageView1.image = UIImage(named: display[0])
        imageView2.image = UIImage(named: display[1])
        imageView3.image = UIImage(named: display[2])
        imageView4.image = UIImage(named: display[3])
        imageView5.image = UIImage(named: display[4])
    }
    
    // Function created to populate image views with random images.
    // Function created to avoid duplicate code.
    // Parameters Master = which seg is currently getting interacted with
    // Parameters Slave = which seg need to be updated.
    // Paratemter Bool = do we display a image.
    // Added two seg controls so that user dose not have to scroll up to change pictures....
    // also to add complexity and see if I am able to cotrol UI elements with code.
    func selectorFunctionality(displayReviewMessage: Bool, segControlMaster: UISegmentedControl , segControlSlave: UISegmentedControl ){
        
        //  Step 1 pick a image sample to load on the image views.
        if segControlMaster.selectedSegmentIndex == 0 {
            segControlSlave.selectedSegmentIndex = 0
            // Sample from "p" group images meaning programming, (ie p1,p2,p3), as they were saved in the project.
            imageView1.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
        } else if segControlMaster.selectedSegmentIndex == 1 {
            segControlSlave.selectedSegmentIndex = 1
            // Sample from meme image group
            imageView1.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
        } else if segControlMaster.selectedSegmentIndex == 2 {
            segControlSlave.selectedSegmentIndex = 2
            // Sample from cat image group
            imageView1.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
        } else if segControlMaster.selectedSegmentIndex == 3 {
            segControlSlave.selectedSegmentIndex = 3
            // Sample from aww image group
            imageView1.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
        } else if segControlMaster.selectedSegmentIndex == 4 {
            // Display message if bool = true
            if displayReviewMessage == true {
                // message only displayed in special in top seg controller. Top of the screen.
                let alert=UIAlertController(title: "I can tell you like the app :)", message: "please support me by giving me five stars in the app store. Dont worry this friendly message won't go away because i like talking to you.", preferredStyle: UIAlertController.Style.alert)
                // very user focused error message Al, can get annoying. Moral of the story: dont bug you users with app review requests. ;)
                let cancelAction=UIAlertAction(title: "Ok totes, i will!!!!", style:UIAlertAction.Style.cancel, handler: nil)
                alert.addAction(cancelAction)
                present(alert, animated: true, completion: nil)
            }
            // Sample from special image group
            segControlSlave.selectedSegmentIndex = 4
            imageView1.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
        } else {
            print("Cons log chronicals: func selectorFunctionality error")
        }
    }
    
    // Seg view call to populate images and update view after top seg activity.
    // Parameters Master = which seg is currently getting interacted with.
    // Parameters Slave = which seg need to be updated.
    // Paratemter Bool = do we display a image.
    @IBAction func topSwitcher(_ sender: Any) {
        selectorFunctionality(displayReviewMessage: true, segControlMaster: segControl, segControlSlave: segControlBottom)
    }
    
    // Seg view call to populate images and update view after bottom seg activity.
    // Parameters Master = which seg is currently getting interacted with.
    // Parameters Slave = which seg need to be updated.
    // Paratemter Bool = do we display a image.
    @IBAction func bottomSwitch(_ sender: Any) {
        selectorFunctionality(displayReviewMessage: false, segControlMaster: segControlBottom, segControlSlave: segControl)
    }
    
    // Function created to avoid duplicate code.
    // Function handles button interactions
    // Parameters: which button was pressed and needs a update.
    func buttonClicker(button: String) -> String {
        var outputString = "-"
        var section = "-"
        
        // Check live state of segSwitch to pick a image set.
        if segControlBottom.selectedSegmentIndex == 0 {
            section = "p"
        } else if segControlBottom.selectedSegmentIndex == 1 {
            section = "m"
        } else if segControlBottom.selectedSegmentIndex == 2 {
            section = "c"
        } else if segControlBottom.selectedSegmentIndex == 3 {
            section = "a"
        } else if segControlBottom.selectedSegmentIndex == 4 {
            section = "s"
        } else {
            section = "t"
        }
        
        // Edge case user has not made a selection yet.
        if section == "t" {
            outputString = section + String(Int.random(in: 1 ... 4))
            return outputString
        }
        
        // After all this info is collected generate a image for them.
        if button == "imgButton1" {
            outputString = section + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton2" {
            outputString = section + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton3" {
            outputString = section + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton4" {
            outputString = section + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton5" {
            outputString = section + String(Int.random(in: 1 ... 20))
        } else {
            print("Cons log: func buttonClicker Error")
        }
        return outputString
    }
    
    // Begin Section: Button Actions
    // Call function to update images. and another to play a sound.
    // Parameters: which button was pressed and needs a update.
    @IBAction func imgView1Button(_ sender: Any) {
        imageView1.image = UIImage(named: buttonClicker(button: "imgButton1"))
        soundButton()
    }
    
    @IBAction func imgView2Button(_ sender: Any) {
        imageView2.image = UIImage(named: buttonClicker(button: "imgButton2"))
        soundButton()
    }
    
    @IBAction func imgViewButton3(_ sender: Any) {
        imageView3.image = UIImage(named: buttonClicker(button: "imgButton3"))
        soundButton()
    }
    
    @IBAction func imgView4Button(_ sender: Any) {
        imageView4.image = UIImage(named: buttonClicker(button: "imgButton4"))
        soundButton()
    }
    
    @IBAction func imgView5Button(_ sender: Any) {
        imageView5.image = UIImage(named: buttonClicker(button: "imgButton5"))
        soundButton()
    }
    // End Section: Button Actions
    
    // Sound function to play a cat sound when image is tapped.
    func soundButton() {
        // Disable if UI sound toggle is off.
        if soundSwitch.isOn == false {
            return
        } else {
            // Try to load file.
            guard let fileLocation = Bundle.main.path(forResource: "cat1", ofType:"wav") else {
                // File load fail dispay error to user and also log it.
                // Return so app dose not crash
                print("error loading cat audio (not found)")
                let alert=UIAlertController(title: "O no Bob", message: "It looks like my kitty has run away from the mike :). No worries he left a note it reads: 'Stay Pawsitive', aww how sweet", preferredStyle: UIAlertController.Style.alert)
                let cancelAction=UIAlertAction(title: "The cat is forgiven", style:UIAlertAction.Style.cancel, handler: nil)
                alert.addAction(cancelAction)
                present(alert, animated: true, completion: nil)
                return
            }
            
            // do catch loop required of AVAudioPlayer.
            // Try to play sound.
            do {
                let catSound = try AVAudioPlayer(contentsOf: URL(fileURLWithPath: fileLocation))
                self.player = catSound
                catSound.play()
            } catch {
                // File play fail display error to user and also log it.
                // catch prevents app from crashing.
                print("error loading cat audio (currupt)")
                let alert=UIAlertController(title: "O no Bob", message: "The audio recording of the totes adorbs kitten seems to be corrupted, I think it when she ran across the computer.", preferredStyle: UIAlertController.Style.alert)
                let cancelAction=UIAlertAction(title: "The cat is forgiven", style:UIAlertAction.Style.cancel, handler: nil)
                alert.addAction(cancelAction)
                present(alert, animated: true, completion: nil)
            }
        }
    }
}

// Audio Source: http://www.wavsource.com/snds_2018-06-03_5106726768923853/animals/cat_meow2.wav
// Icon Created with: https://iconsflow.com/ Still designed a icon. adobe is not free for students, not worth paying for a icom :)
// Working with sound 4 lines 212, 226,227,228. london app brewery, https://github.com/AFSM1995/simple-ios-applications/tree/master/Xylophone
/* Image Sources: Preloaded pickachu image created with help from: https://imgflip.com/i/3chg8n
 
 Normal Memes
 https://www.reddit.com/r/memes/comments/ddqh9h/support_the_developers/
 https://www.reddit.com/r/memes/comments/ddpkcw/it_took_me_30mins_to_get_the_miliseconds_right/
 https://www.reddit.com/r/memes/comments/ddpaz9/why_jog_at_all/
 https://www.reddit.com/r/memes/comments/ddp947/now_this_gold/
 https://www.reddit.com/r/memes/comments/ddmvxq/thou_shall_be_named_sofa/
 https://www.reddit.com/r/memes/comments/ddnm3c/just_leave_me_please/
 https://www.reddit.com/r/memes/comments/ddrbao/he_is_too_dangerous_to_be_kept_alive/
 https://www.reddit.com/r/memes/comments/ddn428/anime_openings/
 https://www.reddit.com/r/memes/comments/ddqpe8/absolute_bullshite/
 https://www.reddit.com/r/memes/comments/ddnpor/just_made_this_oc/
 https://www.reddit.com/r/memes/comments/ddrfuu/sad_patrick_noises/
 https://www.reddit.com/r/memes/comments/ddmgvj/ambushed/
 https://www.reddit.com/r/memes/comments/ddph7e/he_will_rise/
 https://www.reddit.com/r/memes/comments/ddq7rh/why_though/
 https://www.reddit.com/r/memes/comments/dds70g/poor_mark_i_cried/
 https://www.reddit.com/r/memes/comments/ddm7gz/just_a_little_bit_of_acid/
 https://www.reddit.com/r/memes/comments/ddnmgt/my_sad_backstoryinator/
 https://www.reddit.com/r/memes/comments/ddpcp8/good_job_mr_musk/
 https://www.reddit.com/r/memes/comments/ddqsdh/cannibalism/
 https://www.reddit.com/r/memes/comments/ddlwj9/only_real_men_understand/
 
 Programing Memes
 https://www.reddit.com/r/ProgrammerHumor/comments/ddkyea/types_of_personalities/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddqzzr/relatable/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddnov2/no_shit_wozniak/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddtdfx/time_is_just_relative/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddk39z/lol_i_like_it_though/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddrx5x/sadly_goes_back_to_google/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddngma/first_post/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddlqe1/so_strong/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddl6k0/database_joins_as_hair/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddijii/no_dates_only_updates/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddkh8j/internal_error_server_you/
 https://www.reddit.com/r/ProgrammerHumor/comments/dd6j02/found_this_floating_around/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddpsdc/what_im_always_spewing_out/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddugpx/there_is_something_funky_in_your_data/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddgoc6/warning_passing_argument_1_of_foo_from/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddf6lc/am_i_a_joke_to_you/
 https://www.reddit.com/r/ProgrammerHumor/comments/dd4nlt/roses_are_red_violets_are_blue_blue_screen_of/
 https://www.reddit.com/r/ProgrammerHumor/comments/ddeao1/type_or_flight/
 https://www.reddit.com/r/ProgrammerHumor/comments/dd99lc/a_friend_sent_me_this/
 https://www.reddit.com/r/ProgrammerHumor/comments/dd4y72/thanks_bitbucket/
 
 Cats
 https://www.reddit.com/r/cats/comments/de2a9x/catholic/
 https://www.reddit.com/r/cats/comments/de3fg9/there_may_be_a_million_other_places_to_sit_but/
 https://www.reddit.com/r/cats/comments/de3jl0/my_little_loaf_of_bread/
 https://www.reddit.com/r/cats/comments/de1ytt/my_14yearold_cat_sleeps_on_her_paw/
 https://www.reddit.com/r/cats/comments/de36dq/found_this_little_guy_in_the_woods_and_took_him/
 https://www.reddit.com/r/cats/comments/de1q0x/is_my_cat_hitting_on_me/
 https://www.reddit.com/r/cats/comments/de4tyu/kittens_first_cat_ride/
 https://www.reddit.com/r/cats/comments/de6bsl/out_for_a_ride/
 https://www.reddit.com/r/cats/comments/de0vph/meet_teun_1_yo_one_of_the_cutest_little_kittens/
 https://www.reddit.com/r/cats/comments/de3qxw/a_photo_of_my_cat/
 https://www.reddit.com/r/cats/comments/de69ia/nice_couple_looking_beautiful/
 https://www.reddit.com/r/cats/comments/ddvx3q/80_sure_this_is_a_cat_if_not_please_delete/
 https://www.reddit.com/r/cats/comments/de5chs/at_dawn_we_strike/
 https://www.reddit.com/r/cats/comments/de4mm0/walk_away_this_doesnt_concern_you/
 https://www.reddit.com/r/cats/comments/de4o7o/condo_life/
 https://www.reddit.com/r/cats/comments/de3maa/i_spy_toe_beans/
 https://www.reddit.com/r/cats/comments/de5y30/floof/
 https://www.reddit.com/r/cats/comments/de691h/soo_cute/
 https://www.reddit.com/r/cats/comments/de6t64/my_sisters_cat_just_recently_had_6_babies_this_is/
 https://www.reddit.com/r/cats/comments/de2ue8/must_capture_butterfly/
 
 Aww
 https://www.reddit.com/r/aww/comments/de1pyr/this_big_gal_followed_me_round_the_enclosure/
 https://www.reddit.com/r/aww/comments/de53ir/rate_this_haircut_out_of_ten/
 https://www.reddit.com/r/aww/comments/ddyml5/slumber_party/
 https://www.reddit.com/r/aww/comments/de04pl/my_cousins_cutie_pie_say_hello_to_four_month_old/
 https://www.reddit.com/r/aww/comments/ddwsd8/mama_duck_taking_her_kids_shopping/
 https://www.reddit.com/r/aww/comments/ddvsnz/moths_can_be_cute_too/
 https://www.reddit.com/r/aww/comments/ddw5vm/olive_and_her_first_baby_victory/
 https://www.reddit.com/r/aww/comments/ddxqwl/dog_progression/
 https://www.reddit.com/r/aww/comments/ddxop8/im_part_of_an_opossum_rescue_group_this_is_one_of/
 https://www.reddit.com/r/aww/comments/ddw1hf/mistakes_were_made/
 https://www.reddit.com/r/aww/comments/de6yus/i_crocheted_mewtwo_and_mew/
 https://www.reddit.com/r/aww/comments/de3z9k/delivery/
 https://www.reddit.com/r/aww/comments/de49zx/my_girlfriend_bought_my_cat_a_halloween_costume/
 https://www.reddit.com/r/aww/comments/de3co2/he_couldnt_get_enough_boops_on_his_snoot/
 https://www.reddit.com/r/aww/comments/de1fa9/when_you_think_its_a_giant_spider_but_its_just/
 https://www.reddit.com/r/aww/comments/ddp326/stop_youre_embarrassing_me/
 https://www.reddit.com/r/beagle/comments/ddw2x4/happy_lil_sully_boy_soaking_up_the_sunshine/
 https://www.reddit.com/r/aww/comments/de4u5l/blended_families/
 https://www.reddit.com/r/aww/comments/de6v3r/winnie/
 https://www.reddit.com/r/aww/comments/de6dsa/drop_a_for_those_eyes/
 
 Special
 https://www.reddit.com/r/Weird/comments/de3xxw/straight_banana/
 https://www.reddit.com/r/Weird/comments/ddmf6s/nobody_me_at_2am/
 https://www.reddit.com/r/Weird/comments/dcc3yq/i_am_this_pole/
 https://www.reddit.com/r/Weird/comments/dcfrs1/buff_frog/
 https://www.reddit.com/r/oddlyterrifying/comments/dc0ujw/_/
 https://www.reddit.com/r/Weird/comments/dc8lct/the_mooboi/
 https://www.reddit.com/r/Weird/comments/dazd98/tim_walker_flying_geishas/
 https://www.reddit.com/r/Weird/comments/dakuat/random_act_of_kindness/
 https://www.reddit.com/r/Weird/comments/da5bz8/rare_orchids_that_look_like_monkey_faces/
 https://www.reddit.com/r/Weird/comments/d7md13/wth_cda_chicken/
 https://www.reddit.com/r/Weird/comments/d6dt28/is_this_real/
 https://www.reddit.com/r/awwwtf/comments/d5wt7z/the_black_rain_frog/
 https://www.reddit.com/r/EngineeringPorn/comments/ddyu3j/transparent_pinball_machine/
 https://www.reddit.com/r/bicycling/comments/ddao68/no_wet_shoes_today/
 https://www.reddit.com/r/EngineeringPorn/comments/dd69vs/operating_a_metal_lathe_at_leys_malleable/
 https://www.reddit.com/r/EngineeringPorn/comments/dceppk/the_inside_of_a_semi_truck_transmission/
 https://www.reddit.com/r/funny/comments/de22p7/behind_the_scenes/
 https://www.reddit.com/r/funny/comments/de1vhk/training_for_the_laser/
 https://www.reddit.com/r/funny/comments/de1fev/that_i_feel_ive_forgotten_something_moment/
 https://www.reddit.com/r/funny/comments/ddy08s/rock_solid_evidence/
 
 Tourture
 http://iphones1955.blogspot.com/2015/01/iphone-6-torture-by-angle-grinder.html
 http://new.whatmobile.net/apple-iphone-7-tortured-in-youtube-stress-test/
 https://www.techspot.com/news/71101-iphone-8-teardown-reveals-smaller-battery-2gb-ram.html
 https://www.youtube.com/watch?v=LH17Lp3aQLg
 https://www.businessinsider.com/gold-iphone-5s-shot-with-a-sniper-rifle-2013-9
 */

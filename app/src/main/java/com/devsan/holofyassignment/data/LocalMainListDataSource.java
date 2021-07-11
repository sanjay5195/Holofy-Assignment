package com.devsan.holofyassignment.data;

import android.webkit.JavascriptInterface;

import com.devsan.holofyassignment.models.MediaVO;
import com.devsan.holofyassignment.util.DBError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.inject.Inject;

public class LocalMainListDataSource {

    @Inject
    public LocalMainListDataSource() {
    }

    public void getMediaList(DataResponseListener<ArrayList<MediaVO>> listener) {

        ArrayList<MediaVO> mediaVOS = makeVideoList();

        if(!mediaVOS.isEmpty()) {

            listener.onSuccess(mediaVOS);
        } else {

            listener.onFailure(DBError.EMPTY_LIST.getName());
        }
    }

    private ArrayList<MediaVO> makeVideoList() {

        ArrayList<MediaVO> mediaVOS = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject("{\"videos\":[{\"description\":\"BigBuckBunnytellsthestoryofagiantrabbitwithaheartbiggerthanhimself.Whenonesunnydaythreerodentsrudelyharasshim,somethingsnaps...andtherabbitain'tnobunnyanymore!Inthetypicalcartoontraditionhepreparesthenastyrodentsacomicalrevenge.\\n\\nLicensedundertheCreativeCommonsAttributionlicense\\nhttp://www.bigbuckbunny.org\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4\"],\"subtitle\":\"ByBlenderFoundation\",\"thumb\":\"https://i.ytimg.com/vi/aqz-KE-bpKQ/maxresdefault.jpg\",\"title\":\"BigBuckBunny\"},{\"description\":\"ThefirstBlenderOpenMoviefrom2006\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4\"],\"subtitle\":\"ByBlenderFoundation\",\"thumb\":\"https://upload.wikimedia.org/wikipedia/commons/e/e4/Elephants_Dream_s5_proog.jpg\",\"title\":\"ElephantDream\"},{\"description\":\"HBOGOnowworkswithChromecast--theeasiestwaytoenjoyonlinevideoonyourTV.ForwhenyouwanttosettleintoyourIronThronetowatchthelatestepisodes.For$35.\\nLearnhowtouseChromecastwithHBOGOandmoreatgoogle.com/chromecast.\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4\"],\"subtitle\":\"ByGoogle\",\"thumb\":\"https://i.ytimg.com/vi/Dr9C2oswZfA/maxresdefault.jpg\",\"title\":\"ForBiggerBlazes\"},{\"description\":\"IntroducingChromecast.TheeasiestwaytoenjoyonlinevideoandmusiconyourTV—forwhenBatman'sescapesaren'tquitebigenough.For$35.LearnhowtouseChromecastwithGooglePlayMoviesandmoreatgoogle.com/chromecast.\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4\"],\"subtitle\":\"ByGoogle\",\"thumb\":\"https://i.vimeocdn.com/video/997283427_1280x720.jpg\",\"title\":\"ForBiggerEscape\"},{\"description\":\"IntroducingChromecast.TheeasiestwaytoenjoyonlinevideoandmusiconyourTV.For$35.Findoutmoreatgoogle.com/chromecast.\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4\"],\"subtitle\":\"ByGoogle\",\"thumb\":\"https://i.ytimg.com/vi/YavRJ8a9Up4/maxresdefault.jpg\",\"title\":\"ForBiggerFun\"},{\"description\":\"IntroducingChromecast.TheeasiestwaytoenjoyonlinevideoandmusiconyourTV—forthetimesthatcallforbiggerjoyrides.For$35.LearnhowtouseChromecastwithYouTubeandmoreatgoogle.com/chromecast.\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4\"],\"subtitle\":\"ByGoogle\",\"thumb\":\"https://i.vimeocdn.com/video/1103385638_1280x720.jpg\",\"title\":\"ForBiggerJoyrides\"},{\"description\":\"IntroducingChromecast.TheeasiestwaytoenjoyonlinevideoandmusiconyourTV—forwhenyouwanttomakeBuster'sbigmeltdownsevenbigger.For$35.LearnhowtouseChromecastwithNetflixandmoreatgoogle.com/chromecast.\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4\"],\"subtitle\":\"ByGoogle\",\"thumb\":\"https://vbcdn.com/cdn/download/201307251374748330657970810.jpg\",\"title\":\"ForBiggerMeltdowns\"},{\"description\":\"Sintelisanindependentlyproducedshortfilm,initiatedbytheBlenderFoundationasameanstofurtherimproveandvalidatethefree/opensource3DcreationsuiteBlender.Withinitialfundingprovidedby1000sofdonationsviatheinternetcommunity,ithasagainproventobeaviabledevelopmentmodelforbothopen3Dtechnologyasforindependentanimationfilm.\\nThis15minutefilmhasbeenrealizedinthestudiooftheAmsterdamBlenderInstitute,byaninternationalteamofartistsanddevelopers.Inadditiontothat,severalcrucialtechnicalandcreativetargetshavebeenrealizedonline,bydevelopersandartistsandteamsallovertheworld.\\nwww.sintel.org\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4\"],\"subtitle\":\"ByBlenderFoundation\",\"thumb\":\"https://upload.wikimedia.org/wikipedia/commons/6/6d/Durian_-_Sintel-wallpaper-dragon.jpg\",\"title\":\"Sintel\"},{\"description\":\"SmokingTiretakestheall-newSubaruOutbacktothehighestpointwecanfindinhopesourcustomer-appreciationBalloonLaunchwillgetsomefreeT-shirtsintothehandsofourviewers.\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4\"],\"subtitle\":\"ByGarage419\",\"thumb\":\"https://source.unsplash.com/random/300x200\",\"title\":\"SubaruOutbackOnStreetAndDirt\"},{\"description\":\"TearsofSteelwasrealizedwithcrowd-fundingbyusersoftheopensource3DcreationtoolBlender.Targetwastoimproveandtestacompleteopenandfreepipelineforvisualeffectsinfilm-andtomakeacompellingsci-fifilminAmsterdam,theNetherlands.Thefilmitself,andallrawmaterialusedformakingit,havebeenreleasedundertheCreatieveCommons3.0Attributionlicense.Visitthetearsofsteel.orgwebsitetofindoutmoreaboutthis,ortopurchasethe4-DVDboxwithalotofextras.(CC)BlenderFoundation-http://www.tearsofsteel.org\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4\"],\"subtitle\":\"ByBlenderFoundation\",\"thumb\":\"https://rohles.net/media/pages/articles/tears-of-steel-science-fiction-open-source/f7ff808efd-1579858634/tears-of-steel-paar.jpg\",\"title\":\"TearsofSteel\"},{\"description\":\"TheSmokingTireheadsouttoAdamsMotorsportsParkinRiverside,CAtotestthemostrequestedcarof2010,theVolkswagenGTI.WillitbeattheMazdaspeed3'sstandard-settinglaptime?Watchandsee...\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4\"],\"subtitle\":\"ByGarage419\",\"thumb\":\"https://www.motorbeam.com/wp-content/uploads/Volkswagen-Polo-GTI-Review.jpg\",\"title\":\"VolkswagenGTIReview\"},{\"description\":\"TheSmokingTireisgoingonthe2010BullrunLiveRallyina2011ShelbyGT500,andpostingavideofromtheroadeverysingleday!TheonlyplacetowatchthemisbysubscribingtoTheSmokingTireorwatchingatBlackMagicShine.com\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4\"],\"subtitle\":\"ByGarage419\",\"thumb\":\"https://www.investopedia.com/thmb/Yq799Eg4ChtpzFXfMygND9xtrL4=/3600x2400/filters:fill(auto,1)/GettyImages-499170981-20e252a7742340ab9b03118f93e8d58c.jpg\",\"title\":\"WeAreGoingOnBullrun\"},{\"description\":\"TheSmokingTiremeetsupwithChrisandJorgefromCarsForAGrand.comtoseejusthowfar$1,000cangowhenlookingforacar.TheSmokingTiremeetsupwithChrisandJorgefromCarsForAGrand.comtoseejusthowfar$1,000cangowhenlookingforacar.\",\"sources\":[\"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4\"],\"subtitle\":\"ByGarage419\",\"thumb\":\"https://www.opensourceagenda.com/projects/fwplayer/image.png\",\"title\":\"Whatcarecanyougetforagrand?\"}]}");

            JSONArray videoJsonArray = jsonObject.optJSONArray("videos");

            if(videoJsonArray.length() >0) {

                for (int i = 0; i < videoJsonArray.length(); i++) {

                    JSONObject object = videoJsonArray.optJSONObject(i);
                    mediaVOS.add(new MediaVO(
                            object.optString("title"),
                            object.optJSONArray("sources").optString(0),
                            object.optString("thumb"),
                            object.optString("subtitle")
                    ));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mediaVOS;
    }


}

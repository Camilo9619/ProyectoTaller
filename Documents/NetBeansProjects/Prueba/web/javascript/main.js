/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<script>
    script type="text/javascript">
    // Call carousel manually
    $('#myCarouselCustom').carousel();

    // Go to the previous item
    $("#prevBtn").click(function(){
        $("#myCarouselCustom").carousel("prev");
    });
    // Go to the previous item
    $("#nextBtn").click(function(){
        $("#myCarouselCustom").carousel("next");
    });
</script>

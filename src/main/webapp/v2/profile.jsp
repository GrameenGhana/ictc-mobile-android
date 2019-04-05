<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>View Profile</title>
</head>

<body class="nav-md">

    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>User Profile</h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>User Report <small>Activity report</small></h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>

                    <div class="x_content">
                        <div class="col-md-3 col-sm-3 col-xs-12 profile_left">

                            <div class="profile_img">
                                <!-- end of image cropping -->
                                <div id="crop-avatar">
                                    <!-- Current avatar -->
                                    <img class="img-responsive avatar-view" src="<%= request.getContextPath() %>/theme/gentelella/images/picture.jpg" alt="Avatar" title="Change the avatar">

                                    <!-- Cropping modal -->
                                    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <form class="avatar-form" action="crop.php" enctype="multipart/form-data" method="post">
                                                    <div class="modal-header">
                                                        <button class="close" data-dismiss="modal" type="button">&times;</button>
                                                        <h4 class="modal-title" id="avatar-modal-label">Change Avatar</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="avatar-body">

                                                            <!-- Upload image and data -->
                                                            <div class="avatar-upload">
                                                                <input class="avatar-src" name="avatar_src" type="hidden">
                                                                <input class="avatar-data" name="avatar_data" type="hidden">
                                                                <label for="avatarInput">Local upload</label>
                                                                <input class="avatar-input" id="avatarInput" name="avatar_file" type="file">
                                                            </div>

                                                            <!-- Crop and preview -->
                                                            <div class="row">
                                                                <div class="col-md-9">
                                                                    <div class="avatar-wrapper"></div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <div class="avatar-preview preview-lg"></div>
                                                                    <div class="avatar-preview preview-md"></div>
                                                                    <div class="avatar-preview preview-sm"></div>
                                                                </div>
                                                            </div>

                                                            <div class="row avatar-btns">
                                                                <div class="col-md-9">
                                                                    <div class="btn-group">
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees">Rotate Left</button>
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-15" type="button">-15deg</button>
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-30" type="button">-30deg</button>
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="-45" type="button">-45deg</button>
                                                                    </div>
                                                                    <div class="btn-group">
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees">Rotate Right</button>
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="15" type="button">15deg</button>
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="30" type="button">30deg</button>
                                                                        <button class="btn btn-primary" data-method="rotate" data-option="45" type="button">45deg</button>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <button class="btn btn-primary btn-block avatar-save" type="submit">Done</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- <div class="modal-footer">
                                                                      <button class="btn btn-default" data-dismiss="modal" type="button">Close</button>
                                                                    </div> -->
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.modal -->

                                    <!-- Loading state -->
                                    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
                                </div>
                                <!-- end of image cropping -->
                            </div>

                            <h3>Test User</h3>

                            <ul class="list-unstyled user_data">
                                <li><i class="fa fa-map-marker user-profile-icon"></i> Community, City, Ghana</li>
                                <li><i class="fa fa-briefcase user-profile-icon"></i> Agent</li>
                            </ul>

                            <a class="btn btn-success"><i class="fa fa-edit m-right-xs"></i>Edit Profile</a>
                            <br />
                        </div>

                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <div class="profile_title">
                                <div class="col-md-6">
                                    <h2>User Activity Report</h2>
                                </div>
                                <div class="col-md-6">
                                    <div id="reportrange" class="pull-right" style="margin-top: 5px; background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #E6E9ED">
                                        <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                        <span>December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                                    </div>
                                </div>
                            </div>
                            <!-- start of user-activity-graph -->
                            <div id="graph_bar" style="width:100%; height:280px;"></div>
                            <!-- end of user-activity-graph -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


<script>
    $(function() {
        Morris.Bar({
            element: 'graph_bar',
            data: [
                { "period": "Jan", "Hours worked": 80 },
                { "period": "Feb", "Hours worked": 125 },
                { "period": "Mar", "Hours worked": 176 },
                { "period": "Apr", "Hours worked": 224 },
                { "period": "May", "Hours worked": 265 },
                { "period": "Jun", "Hours worked": 314 },
                { "period": "Jul", "Hours worked": 347 },
                { "period": "Aug", "Hours worked": 287 },
                { "period": "Sep", "Hours worked": 240 },
                { "period": "Oct", "Hours worked": 211 }
            ],
            xkey: 'period',
            hideHover: 'auto',
            barColors: ['#26B99A', '#34495E', '#ACADAC', '#3498DB'],
            ykeys: ['Hours worked', 'sorned'],
            labels: ['Hours worked', 'SORN'],
            xLabelAngle: 60,
            resize: true
        });

        $MENU_TOGGLE.on('click', function() {
            $(window).resize();
        });
    });
</script>

<!-- datepicker -->
<script type="text/javascript">
    $(document).ready(function() {

        var cb = function(start, end, label) {
            console.log(start.toISOString(), end.toISOString(), label);
            $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
            //alert("Callback has fired: [" + start.format('MMMM D, YYYY') + " to " + end.format('MMMM D, YYYY') + ", label = " + label + "]");
        }

        var optionSet1 = {
            startDate: moment().subtract(29, 'days'),
            endDate: moment(),
            minDate: '01/01/2012',
            maxDate: '12/31/2015',
            dateLimit: {
                days: 60
            },
            showDropdowns: true,
            showWeekNumbers: true,
            timePicker: false,
            timePickerIncrement: 1,
            timePicker12Hour: true,
            ranges: {
                'Today': [moment(), moment()],
                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                'This Month': [moment().startOf('month'), moment().endOf('month')],
                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            },
            opens: 'left',
            buttonClasses: ['btn btn-default'],
            applyClass: 'btn-small btn-primary',
            cancelClass: 'btn-small',
            format: 'MM/DD/YYYY',
            separator: ' to ',
            locale: {
                applyLabel: 'Submit',
                cancelLabel: 'Clear',
                fromLabel: 'From',
                toLabel: 'To',
                customRangeLabel: 'Custom',
                daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
                monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
                firstDay: 1
            }
        };
        $('#reportrange span').html(moment().subtract(29, 'days').format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
        $('#reportrange').daterangepicker(optionSet1, cb);
        $('#reportrange').on('show.daterangepicker', function() {
            console.log("show event fired");
        });
        $('#reportrange').on('hide.daterangepicker', function() {
            console.log("hide event fired");
        });
        $('#reportrange').on('apply.daterangepicker', function(ev, picker) {
            console.log("apply event fired, start/end dates are " + picker.startDate.format('MMMM D, YYYY') + " to " + picker.endDate.format('MMMM D, YYYY'));
        });
        $('#reportrange').on('cancel.daterangepicker', function(ev, picker) {
            console.log("cancel event fired");
        });
        $('#options1').click(function() {
            $('#reportrange').data('daterangepicker').setOptions(optionSet1, cb);
        });
        $('#options2').click(function() {
            $('#reportrange').data('daterangepicker').setOptions(optionSet2, cb);
        });
        $('#destroy').click(function() {
            $('#reportrange').data('daterangepicker').remove();
        });
    });
</script>
<!-- /datepicker -->
</body>
</html>

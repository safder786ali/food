package com.example.foodeze.util



import com.example.foodeze.model.HomeCatModelApi
import com.example.foodeze.model.HomeItemProductModelApi
import com.example.foodeze.model.OrderModelApiCall
import com.example.foodeze.model.RespMsgModelApi
import com.google.gson.JsonArray
import com.google.gson.JsonObject

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @POST("get-all-product-categories")
    suspend fun HomeCatAPi(): HomeCatModelApi

    @POST("get-all-products")
    suspend fun HomeProdAPi(): HomeItemProductModelApi

    @FormUrlEncoded
    @POST("like-product")
    suspend fun HomeProdlikeAPi(
        @Field("user_id")user_id: String,
        @Field("product_id")product_id: String,
        @Field("like")like: String
    ): RespMsgModelApi

    @FormUrlEncoded
    @POST("product-detail")
    suspend fun OrderAPi(
        @Field("user_id")user_id: String,
        @Field("product_id")product_id: String
    ): JsonObject

    /*@GET("getAnnouncements")
    fun GetAnnou():Call<AnnouModelApi>



    @GET("getAllProject")
    fun GetProject():Call<ProjectApiModel>

    @GET("getAllTask")
    fun GetTask():Call<AllTasksModelAPI>

    @GET("fetch_departments")
    fun GetDepart():Call<DepMaCalMeModel>

    @GET("fetchEmployee")
    fun GeUserDetails():Call<UserModel>

    @GET("fetch_designation")
    fun GeDesingtionDetails():Call<DepSubCalMeModel>

    @GET("getAllBugs")
    fun GeAllBugs():Call<DepSubCalMeModel>
    @GET("getAllClients")
    fun GetClient():Call<ClinetModelApi>

    @GET("LeaveYearySection")
    fun GeAllLeaveYearly():Call<LeaveYearApiModel>

    @GET("iprestriction")
    fun GetIpRest():Call<IpRestCallApiModel>

    @GET("jobsPosted")
    fun GetJobPost():Call<RevApiCallModel>

    @GET("fetch_department_salary")
    fun GetMangSalDepartSP():Call<MangSalSPModel>

    //bugs
    @GET("getAllBugs")
    fun GetAllBugs():Call<BugsApiModel>

    @FormUrlEncoded
    @POST("fetch_bugs_projects_oppor")
    fun GetBugsProOpper(
        @Field("related")BugProOpper: String

    ):Call<BugsProOpperApiModel>

    @FormUrlEncoded
    @POST("add_bug")
    fun AddBugs(
        @Field("issue_no") Addissue_no: String,
        @Field("bug_title")Addbug_title: String,
        @Field("project_id")Addpro_opper_id: String,
        @Field("reporter")Addreporter: String,
        @Field("priority")Addpriority: String,
        @Field("severity")Addseverity: String,
        @Field("bug_status")Addbug_status: String,
        @Field("permission")Addpermission: String,
        @Field("reproducibility")Addreproducibility: String,
        @Field("bug_description")Addbug_description: String):Call<BugAddApiModel>


    @FormUrlEncoded
    @POST("DeleteBugsData")
    fun GetBugsDelete(
        @Field("bug_id")BugProOpper: String

    ):Call<BugsApiModel>




    //fetch date by post data
    @FormUrlEncoded
    @POST("TransExp")
    fun GetTranExp(
        @Field("user_id")leave_userid: String,
        @Field("designation_id")leave_Degintion: String
    ):Call<JsonObject>

    @FormUrlEncoded
    @POST("holiday")
    fun Getutitle(
        @Field("user_id")holy_userid: String,
        @Field("designation_id")holy_Degintion: String,
        @Field("year")holy_year: String
    ):Call<JsonObject>
    @FormUrlEncoded
    @POST("fetchmanageSalary")
    fun GetPrmangeSal(
        @Field("dept_id")PrMangSal_Dertid: String

    ):Call<PrMangSalModelApiCall>


    @FormUrlEncoded
    @POST("empSalary")
    fun GetEmpSal(
        @Field("user_id")PrMangSal_userid: String,
        @Field("designtation_id")PrMangSal_desinid: String

    ):Call<EmpSalModelApiCall>


    @FormUrlEncoded
    @POST("delete_payroll")
    fun GetEmpSalDelete(
        @Field("payroll_id")payroll_id: String

    ):Call<AddResponApiModelSData>


    @FormUrlEncoded
    @POST("reportList")
    fun GetReport(
        @Field("user_id")leave_userid: String,
        @Field("designation_id")leave_Degintion: String
    ):Call<ReportCallModelApi>

    @FormUrlEncoded
    @POST("invoice")
    fun GetSaleInvoic(
        @Field("user_id")leave_userid: String,
        @Field("designation_id")leave_Degintion: String
    ):Call<SaleApiCallModel>


    @FormUrlEncoded
    @POST("fetchleavemanagement")
    fun GeAllLeaveManagment(
        @Field("user_id")leave_userid: String,
        @Field("designation_id")leave_Degintion: String
    ):Call<LeaveManagementApiCall>

    @FormUrlEncoded
    @POST("salaryTemplate")
    fun GetSalaryTemp(
        @Field("user_id")leave_userid: String,
        @Field("designation_id")leave_Degintion: String
    ):Call<SalTempListApiCallModel>

    @FormUrlEncoded
    @POST("hourlyTemplate")
    fun GetHorltyTemp(
        @Field("user_id")leave_userid: String,
        @Field("designation_id")leave_Degintion: String
    ):Call<HorlyListApiCallModel>



    @FormUrlEncoded
    @POST("makePayment")
    fun GetMakePayment(
        @Field("dept_id")leave_userid: String,
        @Field("sal_date")leave_Degintion: String
    ):Call<MakePaymentModelApiCall>
    //normal post


    @FormUrlEncoded
    @POST("validateLogin")
    fun userLogin(
        @Field("user_name")email: String,
        @Field("pass_code")password: String
    ):Call<RegLoginModel>

    @FormUrlEncoded
    @POST("markMyAttendance")
    fun AddAttenMark(
        @Field("user_id")att_userid: String,
        @Field("ip")att_ip: String,
        @Field("type")att_type: String
    ):Call<DashAttentModel>

     //add data Annoument

    //delete Annoument
    @FormUrlEncoded
    @POST("deleteAnnouncement")
    fun DelAnnouUpdate(
        @Field("ann_id")att_annouid: String
    ):Call<AnnouUploadApi>
     @FormUrlEncoded
     @POST("editAnnounceData")
     fun GetAnnouUpdate(
         @Field("ann_id")att_annouid: String
     ):Call<AnnouModelUpdateApi>
    //addDataAnnousMent
    @Multipart
    @POST("addAnnouncement")
    fun AnnouUpImage(@Part file: MultipartBody.Part,
                     @Part("title") t_title: RequestBody,
                     @Part("description") t_des: RequestBody,
                     @Part("user_id") t_user_id: RequestBody,
                     @Part("start_date") t_startdate: RequestBody,
                     @Part("end_date") t_enddate: RequestBody,
                     @Part("published") t_publies: RequestBody,
                     @Part("shareWith") t_sharewiht: RequestBody): Call<AnnouUploadApi>




    //clinet start

    @GET("fetch_spclient")
    fun GetClientData():Call<SpClientModelApiCall>

    @FormUrlEncoded
    @POST("create_client")
    fun ClinetAdd(
        @Field("compPhone")Clinet_compPhone: String,
        @Field("compName")Clinet_compName: String,
        @Field("compEmail")Clinet_compEmail: String,
        @Field("short_note")Clinet_short_note: String,
        @Field("compWebsite")Clinet_compWebsite: String,
        @Field("compMobile")Clinet_compMobile: String,
        @Field("compFax")Clinet_compFax: String,
        @Field("compAddress")Clinet_compAddress: String,
        @Field("compCity")Clinet_compCity: String,
        @Field("compZipCode")Clinet_compZipCode: String,
        @Field("currency")Clinet_currency: String,
        @Field("compSkype")Clinet_compSkype: String,
        @Field("LinkedinUrl")Clinet_LinkedinUrl: String,
        @Field("faceBookUrL")Clinet_faceBookUrL: String,
        @Field("TwitterURL")Clinet_TwitterURL: String,
        @Field("compLanguage")Clinet_compLanguage: String,
        @Field("countryName")Clinet_countryName: String,
        @Field("compVat")Clinet_compVat: String,
        @Field("hostingCompany")Clinet_hostingCompany: String,
        @Field("hostName")Clinet_hostName: String,
        @Field("compPort")Clinet_compPort: String,
        @Field("compPassword")Clinet_compPassword: String,
        @Field("compUsername")Clinet_compUsername: String,
        @Field("compLatitude")Clinet_compLatitude: String,
        @Field("compLongitude")Clinet_compLongitude: String,
        @Field("customer_group_id")Clinet_customer_group_id: String,
        @Field("smsNoti")Clinet_smsNoti: String
    ):Call<ClinetAddModelApi>

    @FormUrlEncoded
    @POST("update_client")
    fun ClinetUpdate(
        @Field("compPhone")Clinet_compPhone: String,
        @Field("compName")Clinet_compName: String,
        @Field("compEmail")Clinet_compEmail: String,
        @Field("short_note")Clinet_short_note: String,
        @Field("compWebsite")Clinet_compWebsite: String,
        @Field("compMobile")Clinet_compMobile: String,
        @Field("compFax")Clinet_compFax: String,
        @Field("compAddress")Clinet_compAddress: String,
        @Field("compCity")Clinet_compCity: String,
        @Field("compZipCode")Clinet_compZipCode: String,
        @Field("currency")Clinet_currency: String,
        @Field("compSkype")Clinet_compSkype: String,
        @Field("LinkedinUrl")Clinet_LinkedinUrl: String,
        @Field("faceBookUrL")Clinet_faceBookUrL: String,
        @Field("TwitterURL")Clinet_TwitterURL: String,
        @Field("compLanguage")Clinet_compLanguage: String,
        @Field("countryName")Clinet_countryName: String,
        @Field("compVat")Clinet_compVat: String,
        @Field("hostingCompany")Clinet_hostingCompany: String,
        @Field("hostName")Clinet_hostName: String,
        @Field("compPort")Clinet_compPort: String,
        @Field("compPassword")Clinet_compPassword: String,
        @Field("compUsername")Clinet_compUsername: String,
        @Field("compLatitude")Clinet_compLatitude: String,
        @Field("compLongitude")Clinet_compLongitude: String,
        @Field("customer_group_id")Clinet_customer_group_id: String,
        @Field("smsNoti")Clinet_smsNoti: String
    ):Call<ClinetAddModelApi>

    @FormUrlEncoded
    @POST("fetch_client_by_id")
    fun GetClinetFetchUpdate(
        @Field("client_id")Clinet_id: String
    ):Call<ClientUpdateApi>
    //clinet end

    //adddepartment start
    @GET("fetch_spclient")
    fun GetClientForSp():Call<ClinetModelApi>


    @FormUrlEncoded
    @POST("Addnewdepartment")
    fun AddDepartment(
        @Field("department")Depart_id: String,
        @Field("newDepartment")Depart_name: String,
        @Field("departmentHead")Departhead_name: String,
        @Field("designation")Designation: String
    ):Call<AddResponApiModel>


    @GET("fetchDepartmentsWithDesignation")
    fun GetDepartNew():Call<JsonObject>



    @FormUrlEncoded
    @POST("updatedepartmentsbyid")
    fun UpdateDepart(
        @Field("department_id")Depart_id: String,
        @Field("department")Depart_name: String
    ):Call<UpdateResponApiModel>

    @FormUrlEncoded
    @POST("deleteDepartment")
    fun DeleteDepart(
        @Field("dept_id")Depart_id: String
    ):Call<DeleteResponApiModel>


    @FormUrlEncoded
    @POST("updatedesignationbyid")
    fun UpdateDegation(
        @Field("designation_id")Depart_id: String,
        @Field("designation")Depart_name: String
    ):Call<UpdateResponApiModel>

    @FormUrlEncoded
    @POST("deleteDesignation")
    fun DeleteDegation(
        @Field("desig_id")Depart_id: String
    ):Call<DeleteResponApiModel>

    //adddepartment end  deleteDepartment


    //addleave start
    //leeva yealy
    @GET("fetch_designation")
    fun GeDesingtionLeave():Call<DesignationApiCall>


    @FormUrlEncoded
    @POST("add_Yearlyleave")
    fun AddDesignationLeave(@Field("designation_id")designation_id: String,
                            @Field("totalleave")totalleave: String)
            :Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("update_Yearlyleave")
    fun UpdateLeave(@Field("year_leaveid")yearly_id: String,
                            @Field("designation_id")designation_id: String,
                            @Field("totalleave")totalleave: String)
            :Call<UpdateResponApiModel>

    @FormUrlEncoded
    @POST("delete_yearlyleave")
    fun DeleteLeave(@Field("year_leaveid")yearly_id: String)
            :Call<DeleteResponApiModel>

    // leave yealy end

    // leave policy start

    @FormUrlEncoded
    @POST("fetchdesigbydeptid")
    fun GetDegationByDepartId(@Field("dept_id")designation_id: String)
            :Call<DesignationApiCall>

    @FormUrlEncoded
    @POST("Fetchtotalleave")
    fun GetAvaleave(@Field("desig_id")desig_id: String)
            :Call<AvaLeaveModelApiCall>


    @FormUrlEncoded
    @POST("addLeavePolicyData")
    fun Addleave(@Field("lpolicy_department_id")lpolicy_department_id: String,
                 @Field("lpolicy_designation_id")lpolicy_designation_id: String,
                 @Field("lpolicy_category_id")lpolicy_category_id: String,
                 @Field("lpolicy_days")lpolicy_days: String,
                 @Field("lpolicy_gender")lpolicy_gender: String,
                 @Field("lpolicy_effective_date")lpolicy_effective_date: String
                 )
            :Call<AddResponApiModelS>

    // leave polciy end
    // leave  start managment
    //leave end managment
    //
    // leave end
    //IP RESTRICITON API start
    @FormUrlEncoded
    @POST("ip_address_add")
    fun AddIP(@Field("ip_address")ip_address: String)
            :Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("ip_action")
    fun AddAction(@Field("id")ip_id: String,
                  @Field("act")ip_act: String
                  )
            :Call<AddResponApiModelS>
    @FormUrlEncoded
    @POST("delete_Ip")
    fun DeleteAction(@Field("id")ip_id: String)
            :Call<AddResponApiModelS>
    //IP RESTRICITON API end
   // permiss start
    @FormUrlEncoded
    @POST("add_permission")
    fun AddPersmins(@Field("desig_id")desig_id: String,
                  @Field("permission")permission: String
    )
            :Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("fetchdesignation_byid")
    fun GetPersmins(@Field("desig_id")desig_id: String)
            :Call<JsonArray>

    // permission end


    //RecJob start
    @GET("fetchDepartmentsWithDesignation")
    fun GetDepartDegsiongg():Call<RecModelApiCall>

    @FormUrlEncoded
    @POST("create_job")
    fun AddJobffff(
               @Field("job_title")job_title: String,
               @Field("designations_id ")designations_id: String,
               @Field("employment_type")employment_type: String,
               @Field("experience")experience: String,
               @Field("age")age: String,
               @Field("salary_range")salary_range: String,
               @Field("vacancy_no")vacancy_no: String,
               @Field("last_date")last_date: String,
               @Field("posted_date")posted_date: String,
               @Field("job_description")job_description: String,
               @Field("status")status: String,
               @Field("job_permissions")job_permissions: String):Call<JsonObject>


    @FormUrlEncoded
    @POST("create_job")
    fun AddRec(
        @Field("job_title")job_ti: String,
        @Field("designations_id")design_id: String,
        @Field("employment_type")employ_type: String,
        @Field("experience")experie: String,
        @Field("age")ag: String,
        @Field("salary_range")salar: String,
        @Field("vacancy_no")vaca: String,
        @Field("last_date")last: String,
        @Field("posted_date")posted: String,
        @Field("job_description")job_desc: String,
        @Field("status")status: String,
        @Field("job_permissions")job_permissions:String):Call<AddResponApiModelS>


    @FormUrlEncoded
    @POST("update_job")
    fun UpdateRec(
        @Field("job_circular_id")job_id: String,
        @Field("job_title")job_title: String,
        @Field("designations_id")design_id: String,
        @Field("employment_type")employ_type: String,
        @Field("experience")experie: String,
        @Field("age")ag: String,
        @Field("salary_range")salar: String,
        @Field("vacancy_no")vaca: String,
        @Field("last_date")last: String,
        @Field("posted_date")posted: String,
        @Field("job_description")job_desc: String,
        @Field("status")status: String,
        @Field("job_permissions")job_permissions:String):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("fetchjob_byid")
    fun Updatefetch(
        @Field("job_circular_id")job_id: String):Call<RecApiCallModel>


    @FormUrlEncoded
    @POST("delete_job")
    fun Deletefetch(
        @Field("job_circular_id")job_id: String):Call<RecApiCallModel>
    //  fetchjob_byid RecJob end create_job

    //addrepor
    @GET("dailyreport")
    fun GetDataforSpReport():Call<ReportCallSpApi>

   //adduserdata
    @Multipart
    @POST("addReport")
    fun ReportUpImage(@Part("user_type[]") user_type: RequestBody,
                     @Part("admin_list[]") admin_list: RequestBody,
                     @Part("emp_list[]") emp_list: RequestBody,
                     @Part("rpt_date") rpt_date: RequestBody,
                     @Part("rpt_out_time") rpt_out_time: RequestBody,
                     @Part("your_name") your_name: RequestBody,
                     @Part("user_id") user_id: RequestBody,
                     @Part("rpt_meet_goals") rpt_meet_goals: RequestBody,
                     @Part("rpt_issues") rpt_issues: RequestBody,
                     @Part("rpt_summary") rpt_summary: RequestBody,
                     @Part("rpt_task1")rpt_task1: RequestBody,
                     @Part("rpt_task2")rpt_task2: RequestBody,
                     @Part("rpt_task3")rpt_task3: RequestBody,
                     @Part("rpt_tomorrow_goals") pt_tomorrow_goals: RequestBody,
                     @Part("rpt_complaints") rpt_complaints: RequestBody,
                      @Part file: MultipartBody.Part): Call<RepUploadApi>




    //task add
    @GET("fetch_all_projects")
    fun GetDataforSpTask():Call<TaskProjectSpApi>

    @GET("getAllBugs")
    fun GetAllRVTask():Call<BugsApiModel>



    @FormUrlEncoded
    @POST("create_task")
    fun NewAddTask(
        @Field("user_id")user_id: String,
        @Field("task_name")task_name: String,
        @Field("project_id")project_id: String,
        @Field("task_start_date")task_start_date: String,
        @Field("due_date")due_date: String,
        @Field("hourly_rate")hourly_rate : String,
        @Field("task_hour")task_hour: String,
        @Field("task_progress")task_progress: String,
        @Field("task_status")task_status : String,
        @Field("billable")billable: String,
        @Field("permission")permission: String,
        @Field("task_description")task_description: String
    ):Call<AddResponApiModelS>


    @FormUrlEncoded
    @POST("update_tasks_status")
    fun UpdateStatus(
        @Field("task_id")task_id: String,
        @Field("task_status")task_status: String
        ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("fetchtask_byid")
    fun UpdateFetchUpdateID(
        @Field("task_id")task_id: String,
        @Field("user_id")user_id: String,
        @Field("designation_id")designation_id: String
    ):Call<UpdateTaskFetchModelApi>

    @FormUrlEncoded
    @POST("delete_task")
    fun DeleteTaskID(
        @Field("task_id")task_id: String
    ):Call<AddResponApiModelS>


    //User
    @Multipart
    @POST("new_user")
    fun AddUser(
        @Part("full_name")full_name:RequestBody,
        @Part("Employment_id") Employment_id:RequestBody,
        @Part("username") username: RequestBody,
        @Part("password") password:RequestBody,
        @Part("email") email:RequestBody,
        @Part("phone") phone:RequestBody,
        @Part("mobile") mobile:RequestBody,
        @Part("skype_id") skype_id:RequestBody,
        @Part("direction") direction:RequestBody,
        @Part("designations_id")designations_id:RequestBody,
        @Part file: MultipartBody.Part
        ):Call<AddResponApiModelS>

    @Multipart
    @POST("update_user")
    fun UpateUser(
        @Part("user_id")user_id:RequestBody,
        @Part("full_name")full_name:RequestBody,
        @Part("Employment_id") Employment_id:RequestBody,
        @Part("username") username: RequestBody,
        @Part file: MultipartBody.Part,
        @Part("password") password:RequestBody,
        @Part("email") email:RequestBody,
        @Part("phone") phone:RequestBody,
        @Part("mobile") mobile:RequestBody,
        @Part("skype_id") skype_id:RequestBody,
        @Part("direction") direction:RequestBody,
        @Part("designations_id")designations_id:RequestBody
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("delete_user")
    fun DeleteUser(
        @Field("user_id")user_id: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("fetchuser_byid")
    fun FetchUser(
        @Field("user_id")user_id: String
    ):Call<FetchUserModelApi>


    //holdday

    @FormUrlEncoded
    @POST("add_holiday")
    fun AddHoliday(
        @Field("event_name")event_name: String,
        @Field("description")description: String,
        @Field("start_date")start_date: String,
        @Field("end_date")end_date: String,
        @Field("color")descriptioncolo: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("updateHolidaybyid")
    fun UpdateHoliday(
        @Field("holiday_id")holiday_id: String,
        @Field("event_name")event_name: String,
        @Field("description")description: String,
        @Field("start_date")start_date: String,
        @Field("end_date")end_date: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("deleteHoliday")
    fun DeleteHoliday(
        @Field("holiday_id")holiday_id: String
    ):Call<AddResponApiModelS>



    @FormUrlEncoded
    @POST("create_invoice")
    fun AddInvoice(
        @Field("reference_no")reference_no: String,
        @Field("recur_frequency")recur_frequency: String,
        @Field("recur_start_date")recur_start_date: String,
        @Field("recur_end_date")recur_end_date: String,
        @Field("client_id")client_id: String,
        @Field("project_id")project_id: String,
        @Field("invoice_date")invoice_date: String,
        @Field("due_date")due_date: String,
        @Field("discount_type")discount_type: String,
        @Field("everyone")everyone: String,
        @Field("user_id")user_id: String,
        @Field("show_quantity_as")show_quantity_as: String,
        @Field("discount_percent")discount_percent: String,
        @Field("adjustment")adjustment: String,
        @Field("discount_total")discount_total: String,
        @Field("permission")permission: String,
        @Field("notes")notes: String
    ):Call<AddResponApiModelSData>

    @FormUrlEncoded
    @POST("create_project")
    fun AddProject(
        @Field("user_id")user_id: String,
        @Field("project_name")project_name: String,
        @Field("client_id")client_id: String,
        @Field("progress")progress: String,
        @Field("start_date")start_date: String,
        @Field("end_date")end_date: String,
        @Field("billing_type")billing_type: String,
        @Field("fixed_rate")fixed_rate: String,
        @Field("token_amount")token_amount: String,
        @Field("estimate_hours")estimate_hours: String,
        @Field("project_status")project_status: String,
        @Field("demo_url")demo_url: String,
        @Field("permission")permission: String,
        @Field("project_settings")project_settings: String,
        @Field("description")description: String
    ):Call<AddResponApiModelS>




    @FormUrlEncoded
    @POST("update_project_status")
    fun UpdateStatusProject(
        @Field("project_id")task_id: String,
        @Field("project_status")task_status: String
    ):Call<AddResponApiModelS>
    @FormUrlEncoded
    @POST("fetchprojectbyid")
    fun UpdateFetchUpdateIDProject(
        @Field("project_id")project_id: String
    ):Call<ProjectApiModelFetch>

    @FormUrlEncoded
    @POST("delete_project")
    fun DeleteTaskIDProject(
        @Field("project_id")task_id: String
    ):Call<AddResponApiModelS>


    @FormUrlEncoded
    @POST("update_project")
    fun UpdateProject(
        @Field("project_id")project_id: String,
        @Field("project_name")project_name: String,
        @Field("client_id")client_id: String,
        @Field("progress")progress: String,
        @Field("start_date")start_date: String,
        @Field("end_date")end_date: String,
        @Field("billing_type")billing_type: String,
        @Field("fixed_rate")fixed_rate: String,
        @Field("token_amount")token_amount: String,
        @Field("estimate_hours")estimate_hours: String,
        @Field("project_status")project_status: String,
        @Field("demo_url")demo_url: String,
        @Field("permission")permission: String,
        @Field("project_settings")project_settings: String,
        @Field("description")description: String
    ):Call<AddResponApiModelS>


    @Multipart
    @POST("upload_project")
    fun UpateProject(
        @Part file: MultipartBody.Part,
        @Part("project_id")designations_id:RequestBody
    ):Call<AddResponApiModelS>



    //payroll start

    //start salary set temp
    @FormUrlEncoded
    @POST("set_template")
    fun AddSalSetTemp(
        @Field("salary_grade")salary_grade: String,
        @Field("basic_salary")basic_salary: String,
        @Field("overtime_salary")overtime_salary: String,
        @Field("allowance_label")allowance_label: String,
        @Field("allowance_value")allowance_value: String,
        @Field("deduction_label")deduction_label: String,
        @Field("deduction_value")deduction_value: String
    ):Call<AddResponApiModelS>
    //end salary set temp


    //start Set Payroll horulygrade
    @FormUrlEncoded
    @POST("set_hourly_template")
    fun SetHourlyGrade(
        @Field("hourly_grade")hourly_grade: String,
        @Field("hourly_rate")hourly_rate: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("delete_Hourly")
    fun SetFetchHourly(
        @Field("hourly_rate_id")hourly_rate_id: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("update_hourly_template")
    fun SetHourlyGradeUpdate(
        @Field("hourly_rate_id")hourly_rate_id: String,
        @Field("hourly_grade")hourly_grade: String,
        @Field("hourly_rate")hourly_rate: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("delete_Hourly")
    fun SetHourlyGradeDelete(
        @Field("hourly_rate_id")hourly_rate_id: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("update_salary_details")
    fun SetHourlyGradeUpdateData(
        @Field("user_id[]")user_id: String,
        @Field("hourly_status[]")hourly_status: String,
        @Field("hourly_rate_id[]")hourly_rate_id: String,
        @Field("monthly_status[]")monthly_status: String,
        @Field("salary_template_id[]")salary_template_id: String
    ):Call<AddResponApiModelS>
    //end Set Payroll horulygrade
     // Start Advanc Salery

    @GET("fetchadvanceSalary")
    fun GetAdAcbceSalery():Call<AdvanceSalaryApiCallModel>
    @GET("fetchEmployeewithDepartments")
    fun GetAdAcbceSPSalery():Call<AdvacSalModelSpApiCall>

    @FormUrlEncoded
    @POST("AddNewAdvanceSalary")
    fun AddAdvanceSalery(
        @Field("emp_id")emp_id: String,
        @Field("advance_amount")advance_amount: String,
        @Field("deduct_month")deduct_month: String,
        @Field("reason]")reason: String
    ):Call<AddResponApiModelS>


    @FormUrlEncoded
    @POST("delete_advance_salary")
    fun DeleteAdvanceSalery(
        @Field("salary_id")salary_id: String
    ):Call<AddResponApiModelS>

    //End Advanc Salery

    //start provid fund
    @FormUrlEncoded
    @POST("fetchprovidentfund")
    fun GetProvidentFund(
        @Field("year")year:String
    ):Call<ProvidFundModelApiCall>

    @FormUrlEncoded
    @POST("change_PF_status")
    fun ChangeProvidentStatus(
        @Field("pf_id")pf_id:String,
        @Field("status")status:String
    ):Call<AddResponApiModelSData>

    @FormUrlEncoded
    @POST("add_update_PF")
    fun AddProvident(
        @Field("user_id")user_id:String,
        @Field("overtime_date")overtime_date:String,
        @Field("notes")notes:String,
        @Field("status")status:String
    ):Call<AddResponApiModelSData>


    @FormUrlEncoded
    @POST("delete_pf")
    fun Deleteprovident(
        @Field("pf_id")pf_id:String
    ):Call<AddResponApiModelSData>
    //end provid fund



    //start overtime
    @FormUrlEncoded
    @POST("overTime")
    fun GetOverTime(
        @Field("year")year:String
    ):Call<OverTimeModelApiCall>



    @FormUrlEncoded
    @POST("add_update_overtime")
    fun AddOverTime(
        @Field("user_id")user_id:String,
        @Field("overtime_date")overtime_date:String,
        @Field("overtime_hours")overtime_hours:String,
        @Field("notes")notes:String,
        @Field("status")status:String
    ):Call<AddResponApiModelSData>


    @FormUrlEncoded
    @POST("add_update_overtime")
    fun UpdateOverTime(
        @Field("overtime_id")overtime_id:String,
        @Field("user_id")user_id:String,
        @Field("overtime_date")overtime_date:String,
        @Field("overtime_hours")overtime_hours:String,
        @Field("notes")notes:String,
        @Field("status")status:String
    ):Call<AddResponApiModelSData>


    @FormUrlEncoded
    @POST("change_overtime_status")
    fun ChangeOverTimeStatus(
        @Field("overtime_id")pf_id:String,
        @Field("status")status:String
    ):Call<AddResponApiModelSData>


    @FormUrlEncoded
    @POST("delete_overtime")
    fun DeleteOverTime(
        @Field("overtime_id")pf_id:String
    ):Call<AddResponApiModelSData>
    //end overtime

    // payroll end



    //start Tran
    @Multipart
    @POST("AddExpenseData")
    fun AddTranExpense(
        @Part("account_total_balance")account_total_balance:RequestBody,
        @Part("users_idforTransaction")users_idforTransaction:RequestBody,
        @Part file: MultipartBody.Part,
        @Part("expense_title")expense_title:RequestBody,
        @Part("account_id")account_id:RequestBody,
        @Part("expensedate")expensedate:RequestBody,
        @Part("short_note")short_note:RequestBody,
        @Part("expenseamount")expenseamount:RequestBody,
        @Part("expenses_cat_id")expenses_cat_id:RequestBody,
        @Part("paid_by_id")paid_by_id:RequestBody,
        @Part("payment_methods_id")payment_methods_id:RequestBody,
        @Part("expensereference")expensereference:RequestBody,
        @Part("permission")permission:RequestBody
    ):Call<AddResponApiModelS>

    // start Expenc
    @FormUrlEncoded
    @POST("TransExp")
    fun GetTranExpDetails(
        @Field("user_id")leave_userid: String,
        @Field("designation_id")leave_Degintion: String
    ):Call<TranExpApiCallModel>

    @FormUrlEncoded
    @POST("AddNewAccount")
    fun AddTranExpAccount(
        @Field("account_name")account_name: String,
        @Field("description")description: String,
        @Field("balance")balance: String,
        @Field("permission")permission: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("AddNewExpensesCategory")
    fun AddTranExpCat(
        @Field("expenses_name")expenses_name: String,
        @Field("expense_description")expense_description: String
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("AddMethodName")
    fun AddTranExpmethod(
        @Field("method_name")expenses_name: String
    ):Call<AddResponApiModelS>


    @Multipart
    @POST("save_imported_expense")
    fun SaveImportTranExpense(
        @Part fileup: MultipartBody.Part,
        @Part fileatt: MultipartBody.Part,
        @Part filefi: MultipartBody.Part,
        @Part("account_id")account_id:RequestBody,
        @Part("account_total_balance")account_total_balance:RequestBody,
        @Part("users_idforTransaction")users_idforTransaction:RequestBody,
        @Part("category_id")category_id:RequestBody,
        @Part("paid_by")paid_by:RequestBody,
        @Part("payment_methods_id")payment_methods_id:RequestBody,
        @Part("type")type:RequestBody,
        @Part("permission")permission:RequestBody
    ):Call<AddResponApiModelS>


    @Multipart
    @POST("update_expenses")
    fun UpdateTranExpense(
        @Part("trans_id")trans_id:RequestBody,
        @Part("users_idforTransaction")users_idforTransaction:RequestBody,
        @Part file: MultipartBody.Part,
        @Part("accountsss_id")account_id:RequestBody,
        @Part("expenseamount")expenseamount:RequestBody,
        @Part("expense_title")expense_title:RequestBody,
        @Part("expensedate")expensedate:RequestBody,
        @Part("short_note")short_note:RequestBody,
        @Part("expenses_cat_id")expenses_cat_id:RequestBody,
        @Part("paid_by_id")paid_by_id:RequestBody,
        @Part("payment_methods_id")payment_methods_id:RequestBody,
        @Part("expensereference")expensereference:RequestBody,
        @Part("permission")permission:RequestBody
    ):Call<AddResponApiModelS>



    @FormUrlEncoded
    @POST("delete_transaction")
    fun DeleteTranExpmethod(
        @Field("transactions_id")transactions_id: String
    ):Call<AddResponApiModelSData>
    // end Expenc

    //start Dep

    @FormUrlEncoded
    @POST("TransDeposit")
    fun GetTranDepo(
        @Field("user_id")user_id: String,
        @Field("designtation_id")designtation_id: String
    ):Call<TranDeposApiCallModel>


    @Multipart
    @POST("AddDepositData")
    fun AddTranDepost(
        @Part("account_total_balance")account_total_balance:RequestBody,
        @Part("users_idforTransaction")users_idforTransaction:RequestBody,
        @Part file: MultipartBody.Part,
        @Part("expense_title")expense_title:RequestBody,
        @Part("account_id")account_id:RequestBody,
        @Part("expensedate")expensedate:RequestBody,
        @Part("short_note")short_note:RequestBody,
        @Part("expenseamount")expenseamount:RequestBody,
        @Part("expenses_cat_id")expenses_cat_id:RequestBody,
        @Part("paid_by_id")paid_by_id:RequestBody,
        @Part("payment_methods_id")payment_methods_id:RequestBody,
        @Part("expensereference")expensereference:RequestBody,
        @Part("permission")permission:RequestBody
    ):Call<AddResponApiModelS>


    @Multipart
    @POST("update_deposit")
    fun UpdateTranDeposti(
        @Part("trans_id")trans_id:RequestBody,
        @Part("users_idforTransaction")users_idforTransaction:RequestBody,
        @Part file: MultipartBody.Part,
        @Part("accountsss_id")account_id:RequestBody,
        @Part("expenseamount")expenseamount:RequestBody,
        @Part("expense_title")expense_title:RequestBody,
        @Part("expensedate")expensedate:RequestBody,
        @Part("short_note")short_note:RequestBody,
        @Part("expenses_cat_id")expenses_cat_id:RequestBody,
        @Part("paid_by_id")paid_by_id:RequestBody,
        @Part("payment_methods_id")payment_methods_id:RequestBody,
        @Part("expensereference")expensereference:RequestBody,
        @Part("permission")permission:RequestBody
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("delete_deposit_transaction")
    fun DeleteTrDepostmethod(
        @Field("transactions_id")transactions_id: String
    ):Call<AddResponApiModelSData>
    //end Dep

    //start TrTran
    @FormUrlEncoded
    @POST("TransTransfer")
    fun GetTrTran(
        @Field("user_id")user_id: String,
        @Field("designtation_id")designtation_id: String
    ):Call<TrTranApiCallModel>

    @Multipart
    @POST("AddTransferData")
    fun AddTrTran(
        @Part file: MultipartBody.Part,
        @Part("from_account_id")from_account_id:RequestBody,
        @Part("to_account_id")to_account_id:RequestBody,
        @Part("transferdate")transferdate:RequestBody,
        @Part("short_note")short_note:RequestBody,
        @Part("transfer_amount")transfer_amount:RequestBody,
        @Part("payment_methods_id")payment_methods_id:RequestBody,
        @Part("transferreference")transferreference:RequestBody,
        @Part("permission")permission:RequestBody
    ):Call<AddResponApiModelS>


    @Multipart
    @POST("update_transfer")
    fun UpdateTrTran(
        @Part("trans_id")trans_id:RequestBody,
        @Part file: MultipartBody.Part,
        @Part("from_account_id")from_account_id:RequestBody,
        @Part("to_account_id")to_account_id:RequestBody,
        @Part("transferdate")transferdate:RequestBody,
        @Part("short_note")short_note:RequestBody,
        @Part("transfer_amount")transfer_amount:RequestBody,
        @Part("payment_methods_id")payment_methods_id:RequestBody,
        @Part("transferreference")transferreference:RequestBody,
        @Part("permission")permission:RequestBody
    ):Call<AddResponApiModelS>

    @FormUrlEncoded
    @POST("delete_transfer_transaction")
    fun DeleteTr(
        @Field("transfer_id")transfer_id: String
    ):Call<AddResponApiModelSData>
    //end TrTran
    //start TrReport
    @GET("TransReport")
    fun GetTranReport():Call<TranReportModelCallApi>

    //end TrRePort


    //end Tran*/

}


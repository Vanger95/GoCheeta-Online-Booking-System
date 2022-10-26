<template>

<body>
<div class="container text-center">
    <div>
        <h1>Add Your Reservation</h1>
    </div>
    <form th:action="@{/booking/save}" th:object="${booking}"
          method="Post" style="max-width: 600px; margin: 0 auto;">
        <div class="m-3">
            <div class="form-group row">
                <label class="col-4 col-form-label">Customer Full Name: </label>
                <div class="col-8">
                    <input type="text" th:field="*{customerName}" class="form-control" required />
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">pickupLocation: </label>
                <div class="col-8">
                    <select th:field="*{pickupLocation}">
                        <option th:value="'Colombo'" th:text="Colombo"></option>
                        <option th:value="'Gampaha'" th:text="Gampaha"></option>
                        <option th:value="'Galle'" th:text="Galle"></option>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label class="col-4 col-form-label">dropLocation: </label>
                <div class="col-8">
                    <select th:field="*{dropLocation}">
                        <option th:value="'Colombo'" th:text="Colombo"></option>
                        <option th:value="'Gampaha'" th:text="Gampaha"></option>
                        <option th:value="'Galle'" th:text="Galle"></option>
                    </select>
                </div>
            </div>

            <div>
                <button type="submit" class="btn btn-primary">Add</button>
                <button type="button" class="btn btn-secondary m-2" onclick="cancelForm()">Cancel</button>
            </div>
        </div>
    </form>
</div>
</body>

</template>

<script>
    function cancelForm(){
        window.location = "[[@{/customers}]]";
    }
</script>
<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css)
</style>
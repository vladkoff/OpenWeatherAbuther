<#import "parts/common.ftl" as c>

<@c.page>
    <div style="display: flex; flex-direction: column; justify-content: space-around;">
        <div style="display: flex; flex-direction: row; justify-content: space-around;">
            <select name="" id="">
                <option disabled selected>Выбранные города</option>
            </select>
            <select name="" id="">
                <option disabled selected>Добавить город</option>
            </select>
        </div>

        <div style="display: flex; flex-direction: row; justify-content: center;">
            <div><a href="" class="btn" style="border: 1px double blue">One day</a></div>
            <div><a href="" class="btn" style="border: 1px double blue">Five days</a></div>

        </div>
        <div class="card-columns">
<#list weatherList as weather>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${weather.state}</h5>
            <p class="card-text">${weather.humidity}</p>
            <p class="card-text">${weather.pressure}</p>
            <p class="card-text">${weather.temperature}</p>
        </div>
    </div>

</#list>

        </div>

    </div>

</@c.page>
<#import "parts/common.ftl" as c>

<@c.page>
    <div style="display: flex; flex-direction: column; justify-content: space-around;">
        <div style="display: flex; flex-direction: row; justify-content: space-around;">

            <form action="/addCity">
                <input type="text" name="newCityName">
                <button type="submit">Add City</button>
            </form>

        </div>
        <form action="/">


        <select name="APIID" id="">
            <option disabled selected>Выбранные города</option>
                <#list cities as city>
                    <option value="${city.apiId}">${city.name}</option>
                </#list>
        </select>
        <div style="display: flex; flex-direction: row; justify-content: center;">
            <div><button  class="btn" style="border: 1px double blue" type="submit" name="isOneDay" value="true">One day</button></div>
            <div><button  class="btn" style="border: 1px double blue" type="submit" name="isOneDay" value="false">Five days</button></div>
        </div>
        </form>
        <div class="carusel">
        <#if isOneDay>
            <#list weatherList as weather>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${weather.state}</h5>

                        <p class="card-text">Humidity: ${weather.humidity}</p>
                        <p class="card-text">Pressure: ${weather.pressure}</p>
                        <p class="card-text">Temperature: ${weather.temperature}</p>
                    </div>
                    <div class="card-footer">Time: ${weather.date?time}</div>
                </div>
            </#list>

        <#else>
            <#list weathersFiveDays as weather>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${weather.state}</h5>
                        <p class="card-text">Max temperature: ${weather.maxTmp}</p>
                        <p class="card-text">Min temperature: ${weather.minTmp}</p>
                        <p class="card-text">Humidity: ${weather.humidity}</p>
                        <p class="card-text">Pressure: ${weather.pressure}</p>
                    </div>
                    <div class="card-footer" align="center">${weather.dayInString}</div>
                </div>
            </#list>
        </#if>


        </div>

    </div>

</@c.page>
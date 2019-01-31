package com.gwsf.appfornstu.data.repository.datasource.cloud

import android.content.Context
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.stream.JsonReader
import com.gwsf.appfornstu.data.dto.DisciplineDTO
import com.gwsf.appfornstu.data.dto.ProfessorDTO
import com.gwsf.appfornstu.data.repository.datasource.DisciplineDataSource
import io.reactivex.Completable
import io.reactivex.Maybe
import java.io.InputStreamReader
import javax.inject.Inject

class DisciplineCloudDataSource @Inject constructor(
    private val context: Context
) : DisciplineDataSource {

    companion object {
        private const val PATH = "discipline/list_disciplines_forUser_id1.json"
    }

    override fun postListDisciplines(listDisciplines: List<DisciplineDTO>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListDisciplinesByUserId(userId: Int): Maybe<List<DisciplineDTO>> {
        val inputStream = context.resources.assets.open(PATH)
        val jsonParser = JsonParser()
        val jsonElement = jsonParser.parse(JsonReader(InputStreamReader(inputStream)))
        val jsonArray: JsonArray = jsonElement as JsonArray

        val list = jsonArray.map {
            it as JsonObject

            val disciplineDTO = DisciplineDTO(
                it["id"].asInt,
                it["name"].asString
            )

            val mainProfessorJson = it.get("mainProfessor").asJsonObject
            disciplineDTO.mainProfessorDTO = ProfessorDTO(
                mainProfessorJson["id"].asInt,
                mainProfessorJson["firstName"].asString,
                mainProfessorJson["surName"].asString
            )

            val professorMiddleName = mainProfessorJson["middleName"].asString
            if (professorMiddleName.isNotEmpty()) {
                disciplineDTO.mainProfessorDTO.middleName = professorMiddleName
            }

            disciplineDTO
        }
        return Maybe.just(list)
//        return Maybe.error(NumberFormatException())
    }

}
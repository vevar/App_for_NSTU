package com.gwsf.appfornstu.data.repository.factory.datasource.cloud

import com.gwsf.appfornstu.data.dto.DisciplineDTO
import com.gwsf.appfornstu.data.repository.factory.datasource.DisciplineDataSource
import io.reactivex.Maybe
import javax.inject.Inject

class DisciplineCloudDataSource @Inject constructor() : DisciplineDataSource {

    override fun getListDisciplinesByUserId(userId: Int): Maybe<List<DisciplineDTO>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
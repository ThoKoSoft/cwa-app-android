package de.rki.coronawarnapp.risk

import com.google.android.gms.nearby.exposurenotification.ExposureWindow
import de.rki.coronawarnapp.risk.result.AggregatedRiskResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ExposureResultStore @Inject constructor() {

    private val internalResult = MutableStateFlow<AggregatedRiskResult?>(null)
    val result: Flow<AggregatedRiskResult?> = internalResult

    private var entities: Pair<List<ExposureWindow>, AggregatedRiskResult?> = Pair(emptyList(), null)

    var exposureWindowEntities: Pair<List<ExposureWindow>, AggregatedRiskResult?>
        get() = entities
        set(value) {
            entities = value
            internalResult.value = value.second
        }
}

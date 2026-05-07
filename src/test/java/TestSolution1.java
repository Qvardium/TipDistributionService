import org.junit.Test;
import solution1.Delivery;
import solution1.DistributionResult;
import solution1.Participant;
import solution1.TipDistributionService;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestSolution1 {

    @Test
    public void test1() {
        TipDistributionService service = new TipDistributionService();
        Delivery delivery = new Delivery("1","2","3",false,true);
        var result = service.distribute(1000,delivery);

        Map<Participant,Long> map  = new EnumMap<>(Participant.class);
        map.put(Participant.COURIER,850l);
        map.put(Participant.RESTAURANT,100l);
        map.put(Participant.PLATFORM,50l);
        DistributionResult test = new DistributionResult("1",map);

        assertEquals(result,test);
    }

    @Test
    public void test2() {
        TipDistributionService service = new TipDistributionService();
        Delivery delivery = new Delivery("1","2","3",true,false);
        var result = service.distribute(1000,delivery);

        Map<Participant,Long> map  = new EnumMap<>(Participant.class);
        map.put(Participant.COURIER,1000l);
        map.put(Participant.RESTAURANT,0l);
        map.put(Participant.PLATFORM,0l);
        DistributionResult test = new DistributionResult("1",map);

        assertEquals(result,test);
    }

    @Test
    public void test3() {
        TipDistributionService service = new TipDistributionService();
        Delivery delivery = new Delivery("1","2","3",false,true);
        var result = service.distribute(999,delivery);

        Map<Participant,Long> map  = new EnumMap<>(Participant.class);
        map.put(Participant.COURIER,851l);
        map.put(Participant.RESTAURANT,99l);
        map.put(Participant.PLATFORM,49l);
        DistributionResult test = new DistributionResult("1",map);

        assertEquals(result,test);
    }
}

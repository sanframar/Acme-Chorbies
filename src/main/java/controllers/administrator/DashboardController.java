
package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ChirpService;
import services.ChorbiService;
import services.SenseService;
import controllers.AbstractController;
import domain.Chorbi;

@Controller
@RequestMapping("/dashboard/administrator")
public class DashboardController extends AbstractController {

	// Services ---------------------------------------------------------------
	@Autowired
	private ChorbiService	chorbiService;

	@Autowired
	private SenseService	senseService;

	@Autowired
	private ChirpService	chirpService;


	// Constructors -----------------------------------------------------------
	public DashboardController() {
		super();
	}

	// Dashboard ---------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView result;
		result = new ModelAndView("administrator/dashboard");
		//Level C -------------------------------------------------
		// C1
		final Collection<Object[]> numberChorbiPerCountryAndCity;
		numberChorbiPerCountryAndCity = this.chorbiService.numberChorbiPerCountryAndCity();
		result.addObject("numberChorbiPerCountryAndCity", numberChorbiPerCountryAndCity);
		result.addObject("requestURInumberChorbiPerCountryAndCity", "dashboard/administrator/list.do");

		// C2
		final Double[] minMaxAvgAgeOfChorbi2 = this.chorbiService.minMaxAvgAgeOfChorbi2();
		result.addObject("minMaxAvgAgeOfChorbi2", minMaxAvgAgeOfChorbi2);

		//C3
		final Double ratioChorbiesWithNullOrInvalidCreditcard = this.chorbiService.ratioChorbiesWithNullOrInvalidCreditcard();
		result.addObject("ratioChorbiesWithNullOrInvalidCreditcard", ratioChorbiesWithNullOrInvalidCreditcard);

		//C4
		final Double ratioPerChorbiAndSearchTemplateRelationship = this.chorbiService.ratioPerChorbiAndSearchTemplateRelationship();
		result.addObject("ratioPerChorbiAndSearchTemplateRelationship", ratioPerChorbiAndSearchTemplateRelationship);

		//Level B -------------------------------------------------------------------------------
		//B1
		final Collection<Chorbi> chorbiesSortedGotLikes = this.chorbiService.chorbiesSortedGotLikes();
		result.addObject("chorbiesSortedGotLikes", chorbiesSortedGotLikes);
		result.addObject("requestURIchorbiesSortedGotLikes", "dashboard/administrator/list.do");

		//B2
		final Double[] minAvgMaxOfSenses = this.senseService.minAvgMaxOfSenses();
		result.addObject("minAvgMaxOfSenses", minAvgMaxOfSenses);

		//Level A ----------------------------------------------------------------------------------
		//A1
		final Double[] minMaxAvgReciveChirps = this.chorbiService.minMaxAvgReciveChirps();
		result.addObject("minMaxAvgReciveChirps", minMaxAvgReciveChirps);

		//A2
		final Double[] minAvgMaxChirpsSent = this.chirpService.minAvgMaxChirpsSent();
		result.addObject("minAvgMaxChirpsSent", minAvgMaxChirpsSent);

		//A3
		final Collection<Chorbi> findChorbiMoreReciveChirps = this.chorbiService.findChorbiMoreReciveChirps();
		result.addObject("findChorbiMoreReciveChirps", findChorbiMoreReciveChirps);
		result.addObject("requestURIfindChorbiMoreReciveChirps", "dashboard/administrator/list.do");

		//A4
		final Collection<Chorbi> findChorbiMoreSentChirps = this.chorbiService.findChorbiMoreSentChirps();
		result.addObject("findChorbiMoreSentChirps", findChorbiMoreSentChirps);
		result.addObject("requestURIfindChorbiMoreSentChirps", "dashboard/administrator/list.do");

		return result;

	}
}

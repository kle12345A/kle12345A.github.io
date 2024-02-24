using Microsoft.AspNetCore.Mvc;

namespace Lesson01.MVC.Controllers
{
	public class ProductController : Controller
	{
		public IActionResult Index()
		{
			return View();
		}
	}
}
